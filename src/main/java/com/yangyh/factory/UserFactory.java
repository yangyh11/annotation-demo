package com.yangyh.factory;

import com.yangyh.annotation.Init;
import com.yangyh.entity.User;

import java.lang.reflect.Method;

/**
 * @description: 用构造工厂充当注解解析器
 * @author: yangyh
 * @create: 2018-12-13 16:32
 **/
public class UserFactory {

    public static User create(){
        User user = new User();

        Method[] methods = user.getClass().getMethods();

        try {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Init.class)) {
                    Init init = method.getAnnotation(Init.class);
                    method.invoke(user, init.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }
}
