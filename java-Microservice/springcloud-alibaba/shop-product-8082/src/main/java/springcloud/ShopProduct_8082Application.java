package springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //nacos注解
public class ShopProduct_8082Application {

    public static void main(String[] args) {
        SpringApplication.run(ShopProduct_8082Application.class, args);
    }

}
