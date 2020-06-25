package com.syh.demo.mybatis.plus.springboot.basemapper.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.syh.demo.mybatis.plus.springboot.basemapper.entity.User;

import java.util.List;

/**
 * UserService
 *
 * @author HSY
 * @since 2020/06/25 9:20
 */
public interface UserService extends IService<User> {

    /**
     * 查询用户
     * @param user  用户信息
     * @return  {@link List<User>}
     */
    List<User> selectByIdAndName (User user);
}
