//package springcloud.controller;
//
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//import springcloud.entity.Order;
//import springcloud.entity.Product;
//import springcloud.service.ProductService;
//import springcloud.service.impl.TestServiceImpl;
//
////@RestController
//@Slf4j
//public class TestController {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private TestServiceImpl orderService;
//
//    @Autowired
//    private ProductService productService;
//
//    //下单--fegin
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//
//        //调用商品微服务,查询商品信息
//        Product product = productService.findByPid(pid);
//
//        if (product.getPid() == -100) {
//            Order order = new Order();
//            order.setOid(-100L);
//            order.setPname("下单失败");
//            return order;
//        }
//
//        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
//
//        //下单(创建订单)
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//
//        orderService.createOrderBefore(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
//        return order;
//    }
//
//
//}
