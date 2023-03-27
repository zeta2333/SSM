package usts.pycro.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-27 16:01
 */
@Controller
public class PortalController {
    @RequestMapping("/")
    public String portal() {
        return "index";
    }
}
