package springcloud.service;


import springcloud.dta.OrderDto;
import springcloud.entity.Order;

public interface OrderService {
//    public OrderDto addOrder(Integer uid, Integer pid, int num);

    //创建订单
    void createOrder(Order order);
}
