package usts.pycro.spring.test.service.impl;

import usts.pycro.spring.test.dao.UserDao;
import usts.pycro.spring.test.service.UserService;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-20 23:19
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
