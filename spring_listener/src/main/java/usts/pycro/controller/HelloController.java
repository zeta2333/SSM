package usts.pycro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import usts.pycro.service.HelloService;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-31 13:44
 */
@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;
}
