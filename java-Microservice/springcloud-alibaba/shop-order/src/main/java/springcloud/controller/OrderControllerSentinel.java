package springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.service.impl.OrderSentinelServiceImpl;

@RestController
@Slf4j
public class OrderControllerSentinel {

    @Autowired
    private OrderSentinelServiceImpl orderSentinelService;


    @RequestMapping("/order/message1")
    public String message1() {
        orderSentinelService.message();
        return "message1";
    }

    @RequestMapping("/order/message2")
    public String message2() {
        orderSentinelService.message();
        return "message2";
    }


//    int i = 0;
    //测试降级策略的异常比例
//    @RequestMapping("/order/message1")
//    public String message1() {
//        //---------------------------
//        //测试降级的异常比例
//        i++;
//        if (i % 3 == 0) {
//            throw new RuntimeException();
//        }
//        return "message1";
//    }


//    //热点规则：带参数的流控规则
//    @RequestMapping("/order/message3")
//    @SentinelResource("message3")   //标识资源
//    public String message3(String name, Integer age) {
//        return "message3" + name + age;
//    }

    //测试注解@SentinelResource的用法
    @RequestMapping("/order/message")
    public String message(String xx) {
        return orderSentinelService.message("XX");
    }
}
