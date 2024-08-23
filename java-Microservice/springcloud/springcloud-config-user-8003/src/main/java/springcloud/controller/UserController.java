package springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.pojo.User;
import springcloud.service.UserClientService;

import java.util.List;

//提供restfull服务
//@Controller
@RestController    //不走前端
public class UserController {
    @Autowired
    private UserClientService userService;

    //通过id获得
    @HystrixCommand(fallbackMethod = "HystrixGet")
    @GetMapping("/user/get/{id}")
    public User get(@PathVariable("id") int id){
        User user = userService.userById(id);
        if(user==null){
            throw new RuntimeException("id=>"+id+",不存在该用户，或者信息无法找到");
        }
        return user;
    }

    //备选
    public User HystrixGet(@PathVariable("id") int id){
        return new User().setId(id)
                .setName("这个id=>"+id+",没有对应的信息,null---@Hystrix~")
                .setRole("在MySQL中没有这个数据库");
    }

    //得到全部列表
    @RequestMapping("/user/list")
    public List<User> queryUserList(){
        return userService.queryUserList();
    };

}
