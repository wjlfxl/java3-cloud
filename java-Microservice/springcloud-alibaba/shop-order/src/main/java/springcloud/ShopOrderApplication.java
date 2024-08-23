package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import springcloud.service.fallback.ProductServiceFallback;
import springcloud.service.fallback.ProductServiceFallbackFactory;

@SpringBootApplication
@EnableDiscoveryClient  //nacos注解
@EnableFeignClients   //Feign注解
// feign客户端注解,并指定要扫描的包以及配置接口DeptClientService
//@EnableFeignClients(basePackages = {"springcloud"})
public class ShopOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopOrderApplication.class,args);
    }
}
