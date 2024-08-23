package springcloud.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloud.entity.Order;
import springcloud.entity.Product;
import springcloud.service.OrderService;
import springcloud.service.ProductService;

import java.util.List;
import java.util.Random;

//@RestController
//@Slf4j
//@RequestMapping("")
//public class OrderController {
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @Autowired
//    private ProductService productService;
//
//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;
//
//    //加入mq
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//
//        //调用商品微服务,查询商品信息
//        Product product = productService.findByPid(pid);
//
//        //模拟超时   使用容错类的时候的测试
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
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
////        向mq中投递一个下单成功的消息
////        参数一: 指定topic
////        参数二: 指定消息体
//        rocketMQTemplate.convertAndSend("order-topic", order);
//        return order;
//    }




//    //下单--feign
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//
//        //调用商品微服务,查询商品信息
//        Product product = productService.findByPid(pid);
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
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
//        return order;
//    }


        //下单--ribbon负载均衡
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//
//        //调用商品微服务,查询商品信息
//        //问题:1 代码可读性不好  2 编程风格不统一
//        Product product =
//                restTemplate.getForObject("http://service-product/product/" + pid, Product.class);
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
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
//        return order;
//    }


//        //下单--最简单的自定义负载均衡
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//
//        //调用商品微服务,查询商品信息
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        //随机选择
//        int index = new Random().nextInt(instances.size());//0 1 2  取长度
//        ServiceInstance instance = instances.get(index);
//
//        Product product =
//                restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + pid, Product.class);
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
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
//        return order;
//    }



    //nacos下单
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//
//        //调用商品微服务,查询商品信息
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");//从服务名中确定数据
//        ServiceInstance instance = instances.get(0);  //调用提供者服务集群中的第几个service-product服务
//
//        Product product =
//                restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + pid, Product.class);
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
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
//        return order;
//    }



//    /**
//     * 下单
//     * @return
//     */
//    @RequestMapping("/order/prod/{pid}")
//    public Order list(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//        Product product =restTemplate.getForObject("http://localhost:8081/product/"+pid, Product.class); //转发
//        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
////        //调用商品微服务,查询商品信息
////        //问题:
        //1 一旦服务提供者的地址信息变化了,我们就不得不去修改服务调用者的java代码
        //2 一旦无法提供者做了集群,服务调用者一方无法实现负载均衡的去调用
        //3 一旦微服务变得越来越多,如何来管理这个服务清单就成了问题

//        //下单(创建订单)
//        Order order = new Order();
//        order.setUid(1);  //userid
//        order.setUsername("测试用户");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//        return order;
//
//    }

//}
