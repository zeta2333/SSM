package usts.pycro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-30 17:18
 */
@Controller
public class TestController {
    @RequestMapping("/test/hello")
    public String testHello() {
        System.out.println(1 / 0);
        return "success";
    }
}
