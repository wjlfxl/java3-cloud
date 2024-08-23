package springcloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderSentinelServiceImpl {

    int i = 0;
    //SentinelResource 定义一个资源
    //定义当资源内部发生异常的时候的处理逻辑
    //blockHandler  定义当资源内部发生了BlockException应该进入的方法[捕获的是Sentinel定义的异常]
    //fallback      定义当资源内部发生了Throwable应该进入的方法
    @SentinelResource(
            value = "message",
            blockHandlerClass = OrderSentinelServiceImplBlockHandler.class,
            blockHandler = "blockHandler",
            fallbackClass = OrderSentinelServiceImplFallback.class,
            fallback = "fallback"
    )


//参数类型要跟OrderSentinelServiceImplBlockHandler里的blockHandler方法  OrderSentinelServiceImplFallback里的fallback方法 一致
    public String message(String name) {
        //方便看报错情况，三次报一次错
//        i++;
//        if (i % 3 == 0) {
//            throw new RuntimeException();
//        }
        return "message";
    }

    public String message() {
    return "message";
    }

}
