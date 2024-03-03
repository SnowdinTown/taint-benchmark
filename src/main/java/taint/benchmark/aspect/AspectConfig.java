package taint.benchmark.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfig {

    @Bean
    public Aspect4Controller aspect4Controller() {
        return new Aspect4Controller();
    }
}
