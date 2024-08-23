package springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import springcloud.pojo.User;

import java.util.List;

@Component
public class UserClientServiceFallBackFactory implements FallbackFactory {

    @Override
    public UserClientService create(Throwable cause) {
        return new UserClientService() {
            @Override
            public User userById(int id) {
                return new User()
                        .setId(id)
                        .setName("id=>" + id + "没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭")
                        .setRole("没有数据~");
            }

            @Override
            public List<User> queryUserList() {
                return null;
            }

            @Override
            public boolean addUser(User user) {
                return false;
            }

        };
    }
}
