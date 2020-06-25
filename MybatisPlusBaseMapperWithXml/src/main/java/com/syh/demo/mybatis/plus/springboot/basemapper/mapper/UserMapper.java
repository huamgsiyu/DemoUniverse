package com.syh.demo.mybatis.plus.springboot.basemapper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syh.demo.mybatis.plus.springboot.basemapper.entity.User;

import java.util.List;

/**
 * UserMapper
 *
 * @author HSY
 * @since 2020/06/24 21:37
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用户
     * @param user  用户信息
     * @return  {@link List<User>}
     */
    List<User> selectByIdAndName (User user);
}