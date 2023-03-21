package usts.pycro.spring.test.controller;

import usts.pycro.spring.test.service.UserService;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-20 23:19
 */
public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
