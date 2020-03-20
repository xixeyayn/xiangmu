package com.aaa.xie.repast.dynamic.datasource;

import com.aaa.xie.repast.dynamic.utils.DBProperties;
import com.aaa.xie.repast.dynamic.utils.PropertiesUtil;
import com.aaa.xie.repast.utils.StringUtil;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import static com.aaa.xie.repast.staticstatus.DataSourceProperties.*;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/14 11:04
 * @Description
 *      动态数据源的自动装配注册类
 *      把自己的数据源加载进springboot源码中，然后通过spring的IOC生成对象
 *      在有对象之前肯定需要把数据源加载进springboot中
 **/
@Configuration
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    /**
     *  指定默认的数据源连接池(常规都使用的是阿里巴巴的druid)
     *  (注意：springboot2.x版本默认使用的数据源连接池hikari，如果这里想使用其他的数据源必须自己配置(因为已经废除了springboot对数据源的自动装配))
     *  所以得自己写这个自动装配类
     *  这里使用阿里巴巴的druid
     *  如果需要使用springboot2.x版本默认的数据源连接池，必须要添加spring-boot-jdbc的jar包
     *  <dependency>
     *      <groupId>org.springframework.boot</groupId>
     *      <artifactId>spring-boot-starter-jdbc</artifactId>
     *  </dependency>
     */
    // springboot2.x默认的连接池
    // private static final String DATA_SOURCE_TYPE_DEFAULT = SPRING_BOOT_DATA_SOURCE;
    // 阿里巴巴的druid
    private static final String DATA_SOURCE_TYPE_DEFAULT = DRUID_DATA_SOURCE;

    /**
     * 默认数据源
     */
    private DataSource defaultDataSource;

    /**
     *  自定义数据源
     */
    private Map<String, DataSource> salveDataSources = new HashMap<String, DataSource>();

    /**
     * @author Seven Lee
     * @description
     *      设置数据源springboot项目所必须要的环境
     * @param [environment]
     * @date 2020/3/14
     * @return void
     * @throws
    **/
    @Override
    public void setEnvironment(Environment environment) {
        initDefaultDataSource(environment);
        initSlaveDataSource(environment);
    }

    /**
     * @author Seven Lee
     * @description
     *      初始化默认数据源
     * @param [env]
     * @date 2020/3/14
     * @return void
     * @throws
    **/
    private void initDefaultDataSource(Environment env) {
        // 1.读取数据源
        String primary = env.getProperty(DATA_SOURCE_PRIMARY);
        // 2.判断是否为null
        if(StringUtil.isEmpty(primary) || null == primary) {
            primary = MYSQL;
        }
        // 3.因为用户没有设置，需要把primary标识加载进Properties中
        PropertiesUtil property = Binder.get(env).bind(DATA_SOURCE_PREFIX, PropertiesUtil.class).get();
        // 4.获取数据源信息
        Map<String, DBProperties> dbMaps = property.getDynamic();
        // 5.循环map
        for (Map.Entry<String, DBProperties> item : dbMaps.entrySet()) {
            // 6.获取默认数据源的唯一标识pollName
            String pollName = item.getKey();
            // 7.判断默认的primary是否一致
            if(primary.equals(pollName)) {
                // 8.设置数据源
                DBProperties dbProperties = item.getValue();
                dbProperties.setPollName(pollName);
                Map<String, Object> dsMap = new HashMap<String, Object>();
                dsMap.put(DRIVER, dbProperties.getDriverClassName());
                dsMap.put(URL, dbProperties.getUrl());
                dsMap.put(USERNAME, dbProperties.getUsername());
                dsMap.put(PASSWORD, dbProperties.getPassword());
                defaultDataSource = buildDataSource(dsMap);
            }
        }

    }

    /**
     * @author Seven Lee
     * @description
     *      加载数据源
     *      解析properties中多数据源的属性
     *      TODO 新加的方法，需要进一步封装(并不完善，待解决)
     * @param [dbMaps]
     * @date 2020/3/14
     * @return java.util.Map<java.lang.String,com.aaa.lee.repast.dynamic.utils.DBProperties>
     * @throws
    **/
    private Map<String ,DBProperties> loadDataSource(Map<String, DBProperties> dbMaps) {
        return null;
    }


    /**
     * @author Seven Lee
     * @description
     *      初始化自定义数据源
     * @param [env]
     * @date 2020/3/14
     * @return void
     * @throws
    **/
    private void initSlaveDataSource(Environment env) {
        String primary = env.getProperty(DATA_SOURCE_PRIMARY);
        PropertiesUtil property = Binder.get(env).bind(DATA_SOURCE_PREFIX, PropertiesUtil.class).get();
        Map<String, DBProperties> dbMaps = property.getDynamic();
        for (Map.Entry<String, DBProperties> item: dbMaps.entrySet()){
            String pollName = item.getKey();
            if(primary.equals(pollName)) {
                continue;
            }
            DBProperties dbProperties = item.getValue();
            dbProperties.setPollName(pollName);
            Map<String, Object> dsMap = new HashMap<String, Object>();
            dsMap.put(DRIVER, dbProperties.getDriverClassName());
            dsMap.put(URL, dbProperties.getUrl());
            dsMap.put(USERNAME, dbProperties.getUsername());
            dsMap.put(PASSWORD, dbProperties.getPassword());
            DataSource ds = buildDataSource(dsMap);
            salveDataSources.put(pollName, ds);
        }
    }

    /**
     * @author Seven Lee
     * @description
     *      构建数据源
     *      真正创建数据源并加载进springboot中的方法
     * @param [dataSourceMap]
     * @date 2020/3/14
     * @return javax.sql.DataSource
     * @throws
    **/
    public DataSource buildDataSource(Map<String, Object> dataSourceMap) {
        try {
            Object type = dataSourceMap.get(TYPE);
            if(null == type) {
                type = DATA_SOURCE_TYPE_DEFAULT;// 默认dataSource
            }
            Class<? extends DataSource> dataSourceType;
            dataSourceType = (Class<? extends DataSource>) Class.forName((String)type);
            String driverClassName = dataSourceMap.get(DRIVER).toString();
            String url = dataSourceMap.get(URL).toString();
            String username = dataSourceMap.get(USERNAME).toString();
            String password = dataSourceMap.get(PASSWORD).toString();
            // 自定义DataSource的配置
            DataSourceBuilder<? extends DataSource> factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url)
                    .username(username).password(password).type(dataSourceType);
            return factory.build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author Seven Lee
     * @description
     *      把数据源注册进IOC容器
     *      使用IOC反向生成对象
     * @param [annotationMetadata, beanDefinitionRegistry]
     * @date 2020/3/14
     * @return void
     * @throws
    **/
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Map<String, Object> targetDataSources = new HashMap<String, Object>();
        // 1.先添加默认的数据源
        targetDataSources.put(DATA_SOURCE, this.defaultDataSource);
        // 2.添加数据源的唯一标识
        DynamicDataSourceContextHolder.dataSourceIds.add(DATA_SOURCE);
        // 3.添加自定的数据源
        targetDataSources.putAll(salveDataSources);
        // 4.循环注册自定义数据源的唯一标识
        for (String key : salveDataSources.keySet()) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        }
        // 5.创建DynamicDataSource
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue(DEFAULT_TARGET_DATA_SOURCE, defaultDataSource);
        mpv.addPropertyValue(TARGET_DATA_SOURCE, targetDataSources);
        // 6.真正的注册
        beanDefinitionRegistry.registerBeanDefinition(DATA_SOURCE, beanDefinition);

    }
}
