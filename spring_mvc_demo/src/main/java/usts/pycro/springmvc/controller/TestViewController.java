package usts.pycro.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-28 20:44
 */
@Controller
public class TestViewController {
    @RequestMapping("/test/view/thymeleaf")
    public String testView() {
        return "success";
    }

    @RequestMapping("/test/view/forward")
    public String testInternalResourceView() {
        return "forward:/test/model";
    }

    @RequestMapping("/test/view/redirect")
    public String testRedirectView() {
        return "redirect:/test/model";
    }
}
