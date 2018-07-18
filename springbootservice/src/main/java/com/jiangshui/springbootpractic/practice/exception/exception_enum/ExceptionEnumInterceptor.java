package com.jiangshui.springbootpractic.practice.exception.exception_enum;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xujiangshui
 * @Date on 2018/7/6 0006
 */

/**
 * 进入controller层之前拦截请求
 * 自定义拦截器
 */
public class ExceptionEnumInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
//        log.info("---------------------开始进入请求地址拦截----------------------------");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
//        log.info("--------------处理请求完成后视图渲染之前的处理操作（Controller方法调用之后）---------------");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
//        log.info("---------------视图渲染之后的操作（主要是用于进行资源清理工作）-------------------------");
        //处理抛出的异常
        Map msg = new HashMap<String,String>();
        if(ex != null){
            if(ex instanceof CrowdEnumException){
                msg.put("result","fail");
                //获取错误的key（错误的名字或类型）
                String code = ((CrowdEnumException) ex).getCode().toString();
                String message = ((CrowdEnumException) ex).getMessages();
                msg.put("messageCode",code);
                msg.put("messageText",message);
            }else{
                msg.put("result","fail");
                msg.put("messageCode","system.error");
                ex.printStackTrace();
            }
            //由jackson提供，主要是用来把对象转换成为一个json字符串返回到前端,
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(msg);
            //response 怎么回事？
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            PrintWriter out =response.getWriter();
            out.print(json);
            out.flush();
            out.close();
        }


    }

}
