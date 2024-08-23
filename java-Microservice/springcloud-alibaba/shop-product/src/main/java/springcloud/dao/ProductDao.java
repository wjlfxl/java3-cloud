package springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springcloud.entity.Product;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
