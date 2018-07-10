package com.jiangshui.springbootpractic.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jiangshui.springboot.service.ServiceTest;
import com.jiangshui.springbootpractic.mapper.config.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xujiangshui
 * @Date on 2018/7/10 0010
 */

@Service(version = "2.0.1")
public class ServiceTestImp implements ServiceTest {
    @Autowired
    UserMapper userMapper;

    @Override
    public String findName(int id){
        String  name =  userMapper.getName(id);
        return name;
    }

    @Override
    public String hello(){
        return "hello";
    }
}
