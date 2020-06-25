package com.syh.demo.mybatis.plus.basemapper.entity;

import lombok.Data;

/**
 * User
 *
 * @author HSY
 * @since 2020/06/24 21:36
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
