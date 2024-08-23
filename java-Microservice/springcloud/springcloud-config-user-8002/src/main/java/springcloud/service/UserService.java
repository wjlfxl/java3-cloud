package springcloud.service;
import springcloud.pojo.User;

import java.util.List;

public interface UserService {

    //得到全部列表
    List<User> queryUserList();

    //通过id获得
    User userById(int id);

    //添加
    boolean addUser(User user);

    //修改
//    int upDateUser(User user);

    //删除
//    int deleteUser(Integer id);

}
