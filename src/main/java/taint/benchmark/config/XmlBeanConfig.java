package taint.benchmark.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:bean.xml"})
public class XmlBeanConfig {
}
