package usts.pycro.spring.factory;

import org.springframework.beans.factory.FactoryBean;
import usts.pycro.spring.pojo.User;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-20 22:53
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
