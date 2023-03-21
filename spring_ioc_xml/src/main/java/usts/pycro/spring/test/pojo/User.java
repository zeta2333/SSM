package usts.pycro.spring.test.pojo;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-20 22:01
 */

public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("生命周期2：依赖注入");
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(Integer id, String username, String password, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public User() {
        System.out.println("生命周期1：实例化");
    }

    public void init(){
        System.out.println("生命周期3：初始化");
    }
    public void destroy(){
        System.out.println("生命周期4：销毁");
    }
}
