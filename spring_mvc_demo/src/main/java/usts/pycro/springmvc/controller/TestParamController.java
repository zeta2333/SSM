package usts.pycro.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import usts.pycro.springmvc.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
 * 4.@RequestHeader：将请求头信息和控制器方法的形参进行绑定
 * 5.@CookieValue：将cookie数据和控制器方法的形参进行绑定
 * 6.通过控制器方法的实体类类型的形参获取请求参数
 * 需要在形参位置设置实体类形参，需要实体类中的属性名和请求参数的名字保持一致
 * 7.解决获取请求参数的乱码问题
 * 在web.xml中配置spring的编码过滤器
 */
@Controller
public class TestParamController {
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName", required = true, defaultValue = "hello") String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jSessionId
    ) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("referer = " + referer);
        System.out.println("jSessionId = " + jSessionId);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user) {
        System.out.println("user = " + user);
        return "success";
    }


}