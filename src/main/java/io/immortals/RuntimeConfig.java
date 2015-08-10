package io.immortals;

import io.immortals.database.DatabaseConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DatabaseConfig.class})
@ComponentScan(basePackageClasses = AppBase.class)
public class RuntimeConfig {

}
