package com.aaa.xie.repast.dynamic.datasource;

import com.aaa.xie.repast.utils.StringUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/14 10:28
 * @Description
 *      创建数据源的上下文:
 *          换句话说就是通过这个类来生成数据源对象
 **/
public class DynamicDataSourceContextHolder {

    /**
     * @author Seven Lee
     * @description
     *      构造方法私有化，实现单例模式(外部无法new对象)
     * @param []
     * @date 2020/3/14
     * @return
     * @throws
    **/
    private DynamicDataSourceContextHolder() {

    }

    /**存放当前线程使用的数据源类型信息
     *
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<String>();

    /**
     * 每一个数据源都会有一个唯一标识:
     *      mysql,oracle,sqlserver...
     *  存放数据源唯一标识的集合
     */
    public static List<String> dataSourceIds = new ArrayList<String>();

    /**
     * @author Seven Lee
     * @description
     *      设置用户所选择数据源
     * @param [dataSourceType]
     * @date 2020/3/14
     * @return void
     * @throws
    **/
    public static void setDataSourceType(String dataSourceType) {
        CONTEXT_HOLDER.set(dataSourceType);
    }

    /**
     * @author Seven Lee
     * @description
     *      获取用户当前选择的数据源
     * @param []
     * @date 2020/3/14
     * @return java.lang.String
     * @throws
    **/
    public static String getDataSourceType() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * @author Seven Lee
     * @description
     *      清空当前线程中的数据源
     *      给用户使用(源码中会自动清空实现，不需要手动调用)
     * @param []
     * @date 2020/3/14
     * @return void
     * @throws
    **/
    public static void clearDataSourceType() {
        CONTEXT_HOLDER.remove();
    }

    /**
     * @author Seven Lee
     * @description
     *      判断当前线程中是否拥有数据源
     * @param [dataSourceId]
     * @date 2020/3/14
     * @return java.lang.Boolean
     * @throws
    **/
    public static Boolean isContainsDataSource(String dataSourceId) {
        return dataSourceIds.contains(dataSourceId);
    }

    /**
     * @author Seven Lee
     * @description
     *      防止在业务之间相互调用的时候导致数据源切换混乱
     *      确保数据源信息从栈中查询(使用链条形式存储的优势(LinkedMap))
     *      为了支持嵌套切换:
     *          如果ABC三个service层，而且这三个service都使用是不同的数据库(mysql,oracle,sqlserver)
     *          其中A调用B中的方法，正好B正在调用C中的方法
     *          一级一级切换调用，形成了链
     *          传统的只设置了当前线程的方式，不能满足此业务需求，必须要模拟栈的行为，实现后进先出的规则
     *          防止数据源切换的时候造成混乱
     *      ArrayDeque():数组的双向队列，并且是没有容量限制
     * @param
     * @date 2020/3/14
     * @return
     * @throws
    **/
    private static final ThreadLocal<Deque<String>> LOOKUP_KEY_HOLDER = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return new ArrayDeque();
        }
    };

    /**
     * @author Seven Lee
     * @description
     *      获取当前线程中的数据源
     * @param []
     * @date 2020/3/14
     * @return java.lang.String
     * @throws
    **/
    public static String peek() {
        return LOOKUP_KEY_HOLDER.get().peek();
    }

    /**
     * @author Seven Lee
     * @description
     *      设置当前线程正在使用的数据源
     *      请遵循源码规则，如果不是必须手动调用，则千万不要手动调用该方法，避免造成大量未及时处理的垃圾数据存在于线程中
     *      如果必须要调用，则调用之后一定要确保最终清除完毕，否则会占用服务器大量的内存
     *              -- 如果调用遇到问题请联系源码作者(Seven Lee:QQ396691973)
     * @param [dataSource]
     * @date 2020/3/14
     * @return void
     * @throws
    **/
    public static void push(String dataSource) {
        LOOKUP_KEY_HOLDER.get().push(StringUtil.isEmpty(dataSource) ? "" : dataSource);
    }

    /**
     * @author Seven Lee
     * @description
     *     清除当前线程数据源
     *     如果当前线程是连续切换的数据源(A-->B-->C)
     *     只会移除掉当前线程的名称，并不影响当前正在运行的线程中数据源(--->运行完毕之后会自动销毁)
     * @param []
     * @date 2020/3/14
     * @return void
     * @throws
    **/
    public static void poll() {
        Deque<String> deque = LOOKUP_KEY_HOLDER.get();
        deque.poll();
        if(deque.isEmpty()) {
            LOOKUP_KEY_HOLDER.remove();
        }
    }

    /**
     * @author Seven Lee
     * @description
     *      无论数据源是否正在运行，强制清空本地线程数据源
     *      如果用户手动调用了push方法，则记得一定要调用这个方法
     *      防止内存泄漏--->造成CPU温度瞬间升高--->烧坏你的主板
     *          -- 如果遇到问题请联系源码作者(Seven Lee:QQ396691973)
     * @param []
     * @date 2020/3/14
     * @return void
     * @throws
    **/
    public static void clear() {
        LOOKUP_KEY_HOLDER.remove();
    }


}
