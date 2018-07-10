package com.jiangshui.springbootpractic.mapper.config;

import com.jiangshui.springbootpractic.model.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author xujiangshui
 * @Date on 2018/6/28 0028
 */
public interface UserMapper extends Mapper<User> {

    public String getName(int id);
}
