package usts.pycro.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-28 19:09
 * 1.通过ModelAndView向请求域共享数据
 * 可以使用其model功能向请求域共享信息
 * 使用view设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值
 * 2.使用Model向请求域共享数据
 * 3.使用ModelMap向请求域共享数据
 * 4.使用Map向请求域共享数据
 * 5.Model和ModelMap和Map的关系
 * 在底层中，这些类型的形参最终都是通过BindingAwareModelMap进行创建的
 */
@Controller
public class TestScopeController {
    @RequestMapping("/test/mav")
    public ModelAndView testMAV() {
        ModelAndView mav = new ModelAndView();
        /**
         * ModelAndView包含model和view的功能
         * model：向请求域中共享数据
         * view：设置逻辑视图，实现页面跳转
         */
        mav.addObject("testRequestScope", "hello,mav");
        //设置逻辑视图
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/str2bytes")
    public ModelAndView str2Bytes(@RequestParam("plaintext") String text) {
        ModelAndView mav = new ModelAndView();
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        mav.addObject("bytes", Arrays.toString(bytes));
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello,model");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "hello,modelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testModelMap(Map<String, Object> map) {
        map.put("testRequestScope", "hello,map");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope", "hello,application");
        return "success";
    }
}
