import com.yangyh.check.UserCheck;
import com.yangyh.factory.UserFactory;
import com.yangyh.entity.User;


/**
 * @description: 自定义注解测试
 * @author: yangyh
 * @create: 2018-12-13 16:39
 **/
public class annotationTest {

    public static void main(String[] args) {

        User user = UserFactory.create();

        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(UserCheck.check(user));
    }
}
