package com.jiangshui.springbootpractic.config.intercept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author xujiangshui
 * @Date on 2018/7/6 0006
 */
public class WebMvcConfig extends WebMvcConfigurerAdapter{
    @Autowired
    private InterceptorConfig interceptorConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(interceptorConfig).addPathPatterns("/**").excludePathPatterns("api/path/login");
    }

}
