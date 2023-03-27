package usts.pycro.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-27 14:14
 */
@Controller
public class HelloController {
    @RequestMapping("/")//此处的"/"被解析为"http://localhost:8080/SpringMVC/"
    public String portal() {
        //将逻辑视图返回
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "success";
    }
}
