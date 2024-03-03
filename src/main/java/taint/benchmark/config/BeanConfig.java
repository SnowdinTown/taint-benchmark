package taint.benchmark.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import taint.benchmark.domain.TestBean;
import taint.benchmark.service.TestService2;
import taint.benchmark.service.impl.TestService2Impl;

@Configuration
public class BeanConfig {

    @Bean
    public TestService2 testService2() {
        return new TestService2Impl();
    }

    @Bean("testBean1")
    public TestBean testBean1() {
        return new TestBean();
    }

    @Bean("testBean2")
    @Scope("prototype")
    public TestBean testBean2() {
        return new TestBean();
    }
}
