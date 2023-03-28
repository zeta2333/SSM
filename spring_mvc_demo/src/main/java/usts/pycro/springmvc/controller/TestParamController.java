package usts.pycro.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-28 8:50
 * 获取请求参数的方式：
 * 1.通过servletAPI获取（原生方法）
 * 只需要在控制器方法的形参位置设置HttpServletRequest类型的形参
 * 就可以在控制器方法中使用request对象获取请求参数
 * 2.通过控制器方法的形参获取
 * 只需要在控制器方法的形参位置，设置一个形参，保持形参的名字和请求参数的名字一致即可
 * 3.@RequestParam：将请求参数和控制器方法的形参进行绑定
 * 三个属性：value、required、defaultValue
 * value：设置和形参绑定的请求参数的名字
 * required：设置是否必须传输value所对应的请求参数
 * 默认值为true：表示必须传输，否则页面报错：Required String parameter 'xxx' is not present
 * 若设置为false：表示不是必须传输，若未传输，则形参值为null
 * defaultValue：设置当未传输value的请求参数时，为形参设置默认值，此时required的属性值无关
 */
@Controller
public class TestParamController {
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName", required = true, defaultValue = "hello") String username,
            String password
    ) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "success";
    }
}

