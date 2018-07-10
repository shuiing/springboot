//package com.jiangshui.springbootpractic.controller;
//
//import com.jiangshui.springbootpractic.mapper.annotation.User1mapper;
//import com.jiangshui.springbootpractic.mapper.config.UserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author xujiangshui
// * @Date on 2018/6/28 0028
// */
//@RestController
//public class HelloWorld {
//    @Autowired
//    User1mapper user1mapper;
//    @Autowired
//    UserMapper userMapper;
//    @RequestMapping("/helloworld")
//    public String Hello(int id){
//        String  name= user1mapper.getName(id);
//        return  "helloworld"+name;
//    }
//
//    @RequestMapping("/hi")
//    public String Hi(int id){
//        String  name= userMapper.getName(id);
//        return  "Hi"+name;
//    }
//}
