package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
// 开启Dashboard
@EnableHystrixDashboard     //开启监控访问http://localhost:9001/hystrix 页面
public class UserConsumerDashboard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerDashboard_9001.class,args);
    }
}
