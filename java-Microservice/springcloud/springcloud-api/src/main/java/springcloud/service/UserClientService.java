package springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springcloud.pojo.User;

import java.util.List;

//@Component   //注入到spring里面
@FeignClient(value = "SPRINGCLOUD-PROVIDER-USER",fallbackFactory = UserClientServiceFallBackFactory.class)//fallbackFactory指定降级配置类
public interface UserClientService {
    //得到全部列表
    //就是把可以处理指定请求的控制方法充当此接口抽象方法的实现，容器中注入的此接口的动态代理对象
    @RequestMapping("/user/list")  //feign需要通过在接口上实现抽象方法的实现
    List<User> queryUserList();

    //通过id获得
    @GetMapping("/user/get/{id}")
    User userById(@PathVariable("id") int id);

    //添加
    @RequestMapping("/user/add")
    boolean addUser(User user);


}
