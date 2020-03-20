package com.aaa.xie.repast.dynamic.interceptor;
import com.aaa.xie.repast.dynamic.annotation.TDS;
import com.aaa.xie.repast.dynamic.datasource.DynamicDataSourceContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/14 11:46
 * @Description
 **/
@Component
public class TDSInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        TDS annotation = handlerMethod.getMethod().getAnnotation(TDS.class);
        if(null == annotation) {
            annotation = handlerMethod.getMethod().getDeclaringClass().getAnnotation(TDS.class);
        }
        if(null != annotation && !"".equals(annotation.value())) {
            DynamicDataSourceContextHolder.setDataSourceType(annotation.value());
        }
        return true;
    }
}
