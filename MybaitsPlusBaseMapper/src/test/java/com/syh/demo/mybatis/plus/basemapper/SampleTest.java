package com.syh.demo.mybatis.plus.basemapper;

import com.syh.demo.mybatis.plus.basemapper.entity.User;
import com.syh.demo.mybatis.plus.basemapper.mapper.UserMapper;
import com.syh.demo.mybatis.plus.basemapper.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * SampleTest
 *
 * @author HSY
 * @since 2020/06/24 21:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setId(11L);
        user.setName("hsy");
        user.setAge(25);
        user.setEmail("22222222222@qq.com");
        userMapper.insert(user);
    }

    @Test
    public void testSave () {
        User user = new User();
        user.setId(13L);
        user.setName("hsy");
        user.setAge(25);
        user.setEmail("22222222222@qq.com");
        userService.save(user);
    }

    @Test
    public void testLambda () {
        List<User> userList = userService.lambdaQuery()
                .list();
        userList.forEach(System.out::println);
    }
}
