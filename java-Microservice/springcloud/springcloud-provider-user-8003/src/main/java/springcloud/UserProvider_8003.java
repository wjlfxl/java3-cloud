package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//启动类
@SpringBootApplication
@EnableEurekaClient   // 开启Eureka客户端注解，在服务启动后自动向注册中心注册服务
@EnableDiscoveryClient   // @EnableEurekaClient 开启服务发现客户端的注解，可以用来获取一些配置的信息，得到具体的微服务
public class UserProvider_8003 {
    public static void main(String[] args) {
        SpringApplication.run(UserProvider_8003.class, args);
    }
}
