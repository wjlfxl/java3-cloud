package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import springcloud.config.ConfigBean;

@SpringBootApplication
//Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心IP地址和端口号
@EnableEurekaClient //开启Eureka 客户端
// feign客户端注解,并指定要扫描的包以及配置接口UserClientService
@EnableFeignClients(basePackages = {"springcloud"})
public class FeignUserConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignUserConsumer_80.class, args);
    }
}
