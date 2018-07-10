package com.jiangshui.springbootpractic.config.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xujiangshui
 * @Date on 2018/7/6 0006
 */

/**
 * 进入controller层之前拦截请求
 * 自定义拦截器
 */
public class InterceptorConfig implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object var3) throws Exception{
//        log.info("---------------------开始进入请求地址拦截----------------------------");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object var3, ModelAndView var4) throws Exception{
//        log.info("--------------处理请求完成后视图渲染之前的处理操作（Controller方法调用之后）---------------");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object var3, Exception var4) throws Exception{
//        log.info("---------------视图渲染之后的操作（主要是用于进行资源清理工作）-------------------------");
    }

}
