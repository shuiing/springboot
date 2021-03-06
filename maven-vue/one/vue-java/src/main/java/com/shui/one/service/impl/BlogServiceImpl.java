package com.shui.one.service.impl;

import com.shui.one.entity.Blog;
import com.shui.one.mapper.BlogMapper;
import com.shui.one.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shui
 * @since 2020-08-03
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
