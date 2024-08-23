package springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

//启动类
@SpringBootApplication
@EnableEurekaClient   // 开启Eureka客户端注解，在服务启动后自动向注册中心注册服务
@EnableDiscoveryClient   // @EnableEurekaClient 开启服务发现客户端的注解，可以用来获取一些配置的信息，得到具体的微服务
@EnableCircuitBreaker // 添加对熔断的支持注解
public class UserProviderHystrix_8002 {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderHystrix_8002.class, args);
    }

    //增加一个 Servlet  访问http://localhost:9001/hystrix
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        //访问该页面就是监控页面 /actuator/hystrix.stream
        registrationBean.addUrlMappings("/actuator/hystrix.stream");

        return registrationBean;
    }

}
