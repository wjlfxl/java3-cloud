package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // 开启Zuul
public class ZuulApplication_9002 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_9002.class,args);
    }
}
