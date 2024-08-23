package springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springcloud.dao.ProductDao;
import springcloud.entity.Product;
import springcloud.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public Product findById(Integer pid) {
        return productDao.findById(pid).get();
    }

    @Transactional
    @Override
    public void reduceInventory(Integer pid, int number) {
        //查询
        Product product = productDao.findById(pid).get();
        //省略校验

        //内存中扣减
        product.setStock(product.getStock() - number);

        //模拟异常
        //int i = 1 / 0;

        //保存
        productDao.save(product);
    }




    //    @Override
//    public ProductDto getProductById(Integer id) {
//        Product product=productDao.getOne(id);
//        ProductDto dto=new ProductDto();
//        if(product!=null)
//            BeanUtils.copyProperties(product,dto);
//        return dto;
//    }
//
//    @Override
//    public List<ProductDto> getAll() {
//        List<Product> products=productDao.findAll();
//        List<ProductDto> list=new ArrayList<>();
//        if(products!=null && products.size() > 0){
//            for(Product p:products) {
//                ProductDto dto = new ProductDto();
//                BeanUtils.copyProperties(p,dto);
//                list.add(dto);
//            }
//        }
//        return  list;
//    }
//
//    @Override
//    public ProductDto sailOut(Integer productId, int num) {
//        Product product=productDao.getOne(productId);
//        if(product==null)
//            return null;
//        if(product.getStock()<num)
//            return null;
//        product.setStock(product.getStock()-num);
//        ProductDto dto=new ProductDto();
//        BeanUtils.copyProperties(product,dto);
//        return dto;
//    }

}
