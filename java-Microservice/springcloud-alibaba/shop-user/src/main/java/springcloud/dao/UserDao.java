package springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springcloud.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
}
