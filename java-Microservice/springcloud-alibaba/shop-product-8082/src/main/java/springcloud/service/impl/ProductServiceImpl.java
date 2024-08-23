package springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springcloud.dao.ProductDao;
import springcloud.entity.Product;
import springcloud.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
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

    @Override
    public Product findById(Integer pid) {
        return productDao.findById(pid).get();
    }
}
