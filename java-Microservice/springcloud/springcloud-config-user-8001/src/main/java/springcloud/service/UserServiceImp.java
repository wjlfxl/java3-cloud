package springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcloud.dao.UserDao;
import springcloud.pojo.User;

import java.util.List;


@Service("UserService")
public class UserServiceImp implements UserClientService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> queryUserList() {
        return userDao.queryUserList();
    }

    @Override
    public User userById(int id) {
        return userDao.userById(id);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }
}
