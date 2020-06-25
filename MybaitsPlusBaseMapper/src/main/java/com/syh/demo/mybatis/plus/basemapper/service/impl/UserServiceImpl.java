package com.syh.demo.mybatis.plus.basemapper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syh.demo.mybatis.plus.basemapper.entity.User;
import com.syh.demo.mybatis.plus.basemapper.mapper.UserMapper;
import com.syh.demo.mybatis.plus.basemapper.service.UserService;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author HSY
 * @since 2020/06/25 9:21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
