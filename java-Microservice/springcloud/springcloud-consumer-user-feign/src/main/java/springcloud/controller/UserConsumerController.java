package springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.pojo.User;
import springcloud.service.UserClientService;

import java.util.List;

@RestController
public class UserConsumerController {

    @Autowired
    private UserClientService userClientService;

    /**
     * 消费方添加部门信息
     * @param user
     * @return
     */
    @RequestMapping("/consumer/user/add")
    public boolean add(User user) {
        return this.userClientService.addUser(user);
    }

    /**
     * 消费方根据id查询部门信息
     * @param id
     * @return
     */
    @RequestMapping("/consumer/user/get/{id}")
    public User get(@PathVariable("id") int id) {
        return this.userClientService.userById(id);
    }

    /**
     * 消费方查询部门信息列表
     * @return
     */
    @RequestMapping("/consumer/user/list")
    public List<User> list() {
        return this.userClientService.queryUserList();
    }


}

