package springcloud.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springcloud.dao.OrderRepository;
import springcloud.dta.OrderDto;
import springcloud.dta.ProductDto;
import springcloud.dta.UserDto;
import springcloud.entity.Order;
import springcloud.service.OrderService;

//@Service
//@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderDao;

    @Override
    public void createOrder(Order order) {
        orderDao.save(order);
    }
}
