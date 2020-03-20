package com.aaa.xie.repast.dynamic.utils;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/14 10:05
 * @Description
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode
public class PropertiesUtil {

    /**
     * 封装默认数据源的名称
     */
    private String primary;

    /**
     * 数据源连接属性封装进链条Map中
     */
    private Map<String, DBProperties> dynamic = new LinkedHashMap<String, DBProperties>();

}
