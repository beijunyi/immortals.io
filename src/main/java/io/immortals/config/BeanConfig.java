package io.immortals.config;

import io.immortals.AppConstants;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AppConstants.class)
public class BeanConfig {

}
