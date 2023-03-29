package usts.pycro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-29 8:54
 * /user
 * 查询所有用户信息 --> /user --> get
 * 根据id查询用户信息 --> /user/1 --> get
 * 添加用户信息 --> /user --> post
 * 更新用户信息 --> /user --> put
 * 删除用户信息 --> /user/1 --> delete
 * <p>
 * 注意：浏览器目前只能发送get和post请求
 * 若要发送put和delete请求，需要在web.xml中配置一个过滤器HiddenHttpMethodFilter
 * 配置过滤器后，发送的请求要满足两个条件，才能将请求方式转换为put或delete
 * 1.当前请求必须为post
 * 当前请求必须传出参数_method,_method的值才是最终的请求方式
 */
@Controller
public class TestRestController {
    //@RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public String getAllUser() {
        System.out.println("查询所有用户信息 --> /user --> get");
        return "success";
    }

    //@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id) {
        System.out.printf("根据id查询用户信息 --> /user/%d --> get\n", id);
        return "success";
    }

    //@RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")
    public String insertUser() {
        System.out.println("添加用户信息 --> /user --> post");
        return "success";
    }

    //@RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String updateUser() {
        System.out.println("修改用户信息 --> /user --> put");
        return "success";
    }

    //@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        System.out.printf("删除用户信息 --> /user/%d --> delete\n", id);
        return "success";
    }
}
