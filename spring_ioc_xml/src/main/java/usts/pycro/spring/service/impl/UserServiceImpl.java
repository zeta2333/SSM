package usts.pycro.spring.service.impl;

import usts.pycro.spring.dao.UserDao;
import usts.pycro.spring.service.UserService;

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
