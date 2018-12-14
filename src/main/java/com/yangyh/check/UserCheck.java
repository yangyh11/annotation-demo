package com.yangyh.check;

import com.yangyh.annotation.Validate;
import com.yangyh.entity.User;

import java.lang.reflect.Field;

/**
 * @description: 注解解析器
 * @author: yangyh
 * @create: 2018-12-13 16:51
 **/
public class UserCheck {

    public static boolean check(User user) {

        if (user == null) {
            System.out.println("校验的对象为空！！");
            return false;
        }

        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Validate.class)) {
                Validate validate = field.getAnnotation(Validate.class);
                if ("age".equals(field.getName())) {
                    if (user.getAge() == null) {
                        if (validate.isNotNull()) {
                            System.out.println("年龄可空校验不通过：不可为空");
                            return false;
                        } else {
                            System.out.println("年龄可空校验通过：可为空");
                            continue;
                        }
                    } else {
                        System.out.println("年龄可控校验通过");
                    }
                }
            }

        }
        return true;
    }
}
