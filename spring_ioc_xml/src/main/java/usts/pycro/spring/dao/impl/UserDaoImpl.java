package usts.pycro.spring.dao.impl;

import usts.pycro.spring.dao.UserDao;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-20 23:20
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
