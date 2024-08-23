package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启动类
@SpringBootApplication
@EnableEurekaServer   //EnableEurekaServer服务端的启动类，可以接受别人注册进来~
public class Eureka_7002 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka_7002.class, args);
    }
}
