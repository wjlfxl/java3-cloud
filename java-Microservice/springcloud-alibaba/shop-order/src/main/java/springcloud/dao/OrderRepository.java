package springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springcloud.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
