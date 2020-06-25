package com.syh.demo.mybatis.plus.springboot.basemapper.timer;

import com.syh.demo.mybatis.plus.springboot.basemapper.entity.User;
import com.syh.demo.mybatis.plus.springboot.basemapper.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * UserTimer
 *
 * @author HSY
 * @since 2020/06/24 21:56
 */
@Component
@Slf4j
public class UserTimer {
    private final UserMapper userMapper;

    public UserTimer(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Scheduled(cron = "*/10 * * * * ?")
    public void insert () {
        User user = new User();
        user.setId(12L);
        user.setName("hsy");
        user.setAge(25);
        user.setEmail("22222222222@qq.com");
        userMapper.insert(user);
    }
}
