package com.aaa.xie.repast.dynamic.annotation;

import java.lang.annotation.*;
import static com.aaa.xie.repast.staticstatus.DataSourceProperties.MYSQL;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/14 10:03
 * @Description
 *      动态数据源切换注解
 *      @Inherited:该注解是在继承的时候起作用
 *          1.当类继承的时候，子类中也可以有父类中注解
 *          2.当接口继承的时候，子接口不能拥有父接口中的注解
 *          3.当实现的时候，实现类中也不能有接口中的注解
 *
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface TDS {

    String value() default MYSQL;

}
