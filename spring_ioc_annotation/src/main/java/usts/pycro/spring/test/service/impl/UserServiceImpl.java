package usts.pycro.spring.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.pycro.spring.test.dao.UserDao;
import usts.pycro.spring.test.service.UserService;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-21 12:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
