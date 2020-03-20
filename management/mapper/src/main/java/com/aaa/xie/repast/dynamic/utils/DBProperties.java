package com.aaa.xie.repast.dynamic.utils;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/14 10:01
 * @Description
 *      从application.properties文件中映射属性值
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode
public class DBProperties {

    /**
     * 定义属性接收数据源名称
     */
    private String pollName;

    private String driverClassName;

    private String url;

    private String username;

    private String password;



}
