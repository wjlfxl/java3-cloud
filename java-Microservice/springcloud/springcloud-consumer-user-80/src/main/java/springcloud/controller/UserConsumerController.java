package springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springcloud.pojo.User;

import java.util.List;

@RestController
public class UserConsumerController {
    /**
     * 理解：消费者，不应该有service层~
     * RestTemplate .... 供我们直接调用就可以了！ 注册到Spring中
     * (地址：url, 实体：Map ,Class<T> responseType)
     * <p>
     * 提供多种便捷访问远程http服务的方法，简单的Restful服务模板~
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 服务提供方地址前缀
     * Ribbon:我们这里的地址，应该是一个变量，通过服务名来访问
     * 客户端的访问方式http://SPRINGCLOUD-PROVIDER-USER" 要区别于提供方的 http://localhost:8001
     */
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-USER";

    /**
     * 消费方查询部门信息列表
     * @return
     */
    @RequestMapping("/consumer/user/list")
    public List<User> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/list", List.class);
    }

    /**
     * 消费方添加部门信息
     * @param user
     * @return
     */
    @RequestMapping("/consumer/user/add")
    public boolean addUser(User user) {
        // postForObject(服务提供方地址(接口),参数实体,返回类型.class)
        return restTemplate.postForObject(REST_URL_PREFIX + "/user/add", user, Boolean.class);
    }

    /**
     * 消费方根据id查询部门信息
     * @param id
     * @return
     */
    @GetMapping("/consumer/user/get/{id}")
    public User get(@PathVariable("id") int id) {
        // getForObject(服务提供方地址(接口),返回类型.class)
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/get/" + id, User.class);
    }

}

