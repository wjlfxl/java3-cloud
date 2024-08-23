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

//
//    //添加
//    @GetMapping("/user/add")
//    public boolean addUser(@RequestBody User user){
//        return  userService.addUser(user);
//    }
//
//    /** DiscoveryClient 可以用来获取一些配置的信息，得到具体的微服务！ */
//    @Autowired
//    private DiscoveryClient client;
//
//    /**
//     * 获取一些注册进来的微服务的信息~，
//     *联合开发用的到
//     * @return
//     */
//    @GetMapping("/user/discovery")
//    public Object discovery() {
//        // 获取微服务列表的清单
//        List<String> services = client.getServices();
//        System.out.println("discovery=>services:" + services);
//        // 得到一个具体的微服务信息,通过具体的微服务id，applicationName；
//        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-USER");
//        for (ServiceInstance instance : instances) {
//            System.out.println(
//                    instance.getHost() + "\t" + // 主机名称
//                            instance.getPort() + "\t" + // 端口号
//                            instance.getUri() + "\t" + // uri
//                            instance.getServiceId() // 服务id
//            );
//        }
//        return this.client;
//    }

}
