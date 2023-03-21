package usts.pycro.spring.dao.impl;

import org.springframework.stereotype.Repository;
import usts.pycro.spring.dao.UserDao;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-21 12:35
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
