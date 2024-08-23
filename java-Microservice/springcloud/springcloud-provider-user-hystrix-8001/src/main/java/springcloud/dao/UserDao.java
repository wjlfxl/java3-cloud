package springcloud.dao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import springcloud.pojo.User;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

//    得到全部列表
    List<User> queryUserList();

    //通过id获得
    User userById(int id);

    //添加
    boolean addUser(User user);

//    修改
//    int upDateUser(User user);
//
//    删除
//    int deleteUser(Integer id);
}
