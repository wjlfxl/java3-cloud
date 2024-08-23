package springcloud.config;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
//    @configuration == spring applicationContext
    @Bean
    @LoadBalanced  //RestTemplate 可以结合 Eureka 来动态发现服务并进行负载均衡的调用。
    //修改 RestTemplate 的配置，增加能够让 RestTemplate 具备负载均衡能力的注解 @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    @LoadBalanced
    public IRule myRule() {
//        return new RandomRule();//使用随机策略
        return new RoundRobinRule();//使用轮询策略
//        return new AvailabilityFilteringRule();//选择并发较小的服务
//        return new RetryRule();//自动重试，使用可用服务
    }

}
