package com.jiangshui.springbootpractic.mapper.annotation;

import com.jiangshui.springbootpractic.model.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author xujiangshui
 * @Date on 2018/6/28 0028
 */
public interface User1mapper extends Mapper<User>{

    @Select("Select username from User where id=#{id}")
    public String  getName(int id);
}
