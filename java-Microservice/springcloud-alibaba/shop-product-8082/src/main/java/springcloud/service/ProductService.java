package springcloud.service;

import springcloud.entity.Product;

public interface ProductService {
    public Product findById(Integer pid);

//    public ProductDto getProductById(Integer id);
//    List<ProductDto> getAll();
//
//    ProductDto sailOut(Integer productId,int num);
}
