package usts.pycro.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-27 15:59
 * 1.@RequestMapping注解标识的位置
 * 标识一个类：设置映射请求的请求路径的初始信息
 * 标识一个方法：设置映射请求请求路径的具体信息
 * 2.@RequestMapping注解的value属性
 * 作用：通过请求的请求路径匹配请求
 * value属性时数组类型，即当前浏览器所发送请求的请求路径匹配value属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 * 3.@RequestMapping注解的method属性
 * 作用：通过请求的请求方式匹配请求
 * method属性是RequestMethod类型的数组，即当前浏览器所发送请求的请求方式匹配method中的任何一种
 * 则当前请求就会被注解所标识的方法进行处理
 * 若value匹配但method不匹配
 * 此时报错 405 - 方法不允许（ Request method 'xxx' not supported）
 * 在@RequestMapping注解的基础上，结合请求方式的一些派生注解
 * @GetMapping,@PostMapping,@DeleteMapping,@PutMapping 4.@RequestMapping注解的params属性
 * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求和请求参数必须满足params的设置
 * params可以使用四种表达式：
 * "param"：表示当前请求的参数中必须携带param
 * "!param"：表示当前请求的参数中一定不能携带param
 * "param=value"：表示当前请求的参数中必须携带param且值必须为value
 * "param!=value"：表示当前请求的参数中可以不携带param，若携带，值一定不能是value
 * 若value和method匹配，但params不匹配
 * 此时 400 - 错误的请求(Parameter conditions "username" not met for actual request parameters)
 * 5.@RequestMapping注解的headers属性
 * 作用：通过请求的请求头信息匹配请求，即浏览器发送的请求必须满足headers的设置
 * 若value和method匹配，但headers不匹配
 * 此时 404 - 未找到
 * 6.SpringMVC支持ant风格的路径
 * 在@RequestMapping注解的value属性中设置一些特殊字符
 * ?：任意的单个字符（不包括?）
 * *：任意个数的任意字符（不包括?和/）
 * **：任意层数的目录，注意使用方式只能将**写在双斜线中，且不能包含任何其他字符
 * 7.@RequestMapping注解使用路径中的占位符
 * 传统：/deleteUser?id=1
 * rest：/user/delete/1
 * 需要在@RequestMapping注解的value属性值所设置的路径中，使用{xxx}表示路径中的数据
 * 再使用@PathVariable注解，将占位符标识的参数和控制器方法的形参进行绑定
 */
@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {
    //此时控制器方法所匹配的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello", "/abc"},
            method = {RequestMethod.POST, RequestMethod.GET},
            //params = {"username","!password","age=20","gender!=女"}
            headers = {"referer"}
    )
    public String hello() {
        return "success";
    }

    @RequestMapping("/a/**/a/test/ant")
    public String testAnt() {
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        System.out.println("username = " + username);
        System.out.println("id = " + id);
        return "success";
    }
}
