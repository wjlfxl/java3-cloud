package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//@RestController
//@Slf4j
//public class NacosConfigController {
//    @Autowired
//    private ConfigurableApplicationContext applicationContext;
//    @GetMapping("/config-test1")
//    public String nacosConfingTest1() {
//        return
//                applicationContext.getEnvironment().getProperty("config.appName"); //从nacos中获得指定键
//    }
//}


//@RestController
//@Slf4j
//@RefreshScope//只需要在需要动态读取配置的类上添加此注解就可以
//public class NacosConfigController {
//    @Value("${config.appName}")    //从nacos中获得指定键
//    private String appName;
//    //2 注解方式
//    @GetMapping("/config-test2")
//    public String nacosConfigTest2() {
//        return appName;
//    }
//}

//@RestController
//@RefreshScope
//public class NacosConfigController {
//    @Value("${config.env}")
//    private String env;
    //3 同一微服务的不同环境下共享配置
//    @GetMapping("/config-test3")
//    public String nacosConfigTest3() {
//        return env;
//    }
//}