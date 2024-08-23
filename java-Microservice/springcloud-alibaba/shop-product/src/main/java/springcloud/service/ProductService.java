package springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import springcloud.dao.ProductDao;
import springcloud.entity.Product;

import java.util.List;


public interface ProductService {

    //根据pid查询商品信息
    public Product findById(Integer pid);

//    public ProductDto getProductById(Integer id);
//    List<ProductDto> getAll();
//
//    ProductDto sailOut(Integer productId,int num);

    //扣减库存
//    void reduceInventory(Integer pid, Integer number);

    public void reduceInventory(Integer pid, int number);
}
