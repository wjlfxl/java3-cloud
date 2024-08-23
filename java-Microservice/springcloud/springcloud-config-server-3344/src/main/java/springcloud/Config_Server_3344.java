package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Config_Server_3344 {
    public static void main(String[] args) {
        SpringApplication.run(Config_Server_3344.class,args);

        /*
        * 访问http://localhost:3344/application-test.yml
        * 或者访问http://localhost:3344/application-dev.yml
        *
        * 也可以是访问http://localhost:3344/application/test/分支名*/
    }
}
