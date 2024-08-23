package springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springcloud.pojo.User;
import springcloud.service.UserClientService;
import springcloud.service.UserService;

import java.util.List;

//提供restfull服务
//@Controller
@RestController    //不走前端
public class UserController {
    @Autowired
    private UserClientService userService;

    //得到全部
    @GetMapping("/user/list")
    public List<User> list(){
        return userService.queryUserList();
    }

    //通过id获得
    @GetMapping("/user/get/{id}")
    public User get(@PathVariable("id") int id){
        return userService.userById(id);
    }


    //添加
    @GetMapping("/user/add")
    public boolean addUser(@RequestBody User user){
        return  userService.addUser(user);
    }

    /** DiscoveryClient 可以用来获取一些配置的信息，得到具体的微服务！ */
    @Autowired
    private DiscoveryClient client;

    /**
     * 获取一些注册进来的微服务的信息~，
     *联合开发用的到
     * @return
     */
    @GetMapping("/user/discovery")
    public Object discovery() {
        // 获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);
        // 得到一个具体的微服务信息,通过具体的微服务id，applicationName；
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-USER");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" + // 主机名称
                            instance.getPort() + "\t" + // 端口号
                            instance.getUri() + "\t" + // uri
                            instance.getServiceId() // 服务id
            );
        }
        return this.client;
    }

}
