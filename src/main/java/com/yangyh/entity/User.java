package com.yangyh.entity;

import com.yangyh.annotation.Init;
import com.yangyh.annotation.Validate;

/**
 * @description: 在数据模型使用注解
 * @author: yangyh
 * @create: 2018-12-13 16:29
 **/
public class User {

    private String name;


    @Validate(isNotNull = true)
    private String age;


    public String getName() {
        return name;
    }

    @Init(value = "张三")
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
