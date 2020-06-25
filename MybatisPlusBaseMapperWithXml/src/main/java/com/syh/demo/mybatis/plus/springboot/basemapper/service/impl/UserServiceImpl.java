package com.syh.demo.mybatis.plus.springboot.basemapper.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syh.demo.mybatis.plus.springboot.basemapper.entity.User;
import com.syh.demo.mybatis.plus.springboot.basemapper.mapper.UserMapper;
import com.syh.demo.mybatis.plus.springboot.basemapper.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author HSY
 * @since 2020/06/25 9:21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Override
    public List<User> selectByIdAndName(User user) {
        return getBaseMapper().selectByIdAndName(user);
    }
}
