package usts.pycro.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import usts.pycro.spring.service.UserService;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-21 12:34
 */
//@Controller("controller")
@Controller
public class UserController {

    @Autowired
    @Qualifier("service")
    private UserService userService;

    //@Autowired
    //public void setUserService(UserService userService) {
    //    this.userService = userService;
    //}

    //@Autowired
    //public UserController(UserService userService) {
    //    this.userService = userService;
    //}

    public void saveUser() {
        userService.saveUser();
    }
}
