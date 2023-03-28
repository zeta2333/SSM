package usts.pycro.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-28 19:09
 * 1.通过ModelAndView向请求域共享数据
 * 可以使用其model功能向请求域共享信息
 * 使用view设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值
 */
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
}
