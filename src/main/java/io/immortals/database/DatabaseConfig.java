package io.immortals.database;

import java.sql.Driver;
import java.util.Properties;
import javax.sql.DataSource;

import io.immortals.AppBase;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

  private final DatabaseSettings settings = new DatabaseSettings();

  @Bean
  public DatabaseSettings databaseSettings() {
    return settings;
  }

  @Bean
  public SessionFactory sessionFactory() throws Exception {
    DataSource ds = new SimpleDriverDataSource((Driver) Class.forName(settings.getDriver()).newInstance(), settings.getUrl());
    LocalSessionFactoryBuilder sfb = new LocalSessionFactoryBuilder(ds);
    sfb.scanPackages(AppBase.class.getPackage().toString() + ".**");

    Properties props = new Properties();
    props.put(AvailableSettings.USER, settings.getUsername());
    props.put(AvailableSettings.PASS, settings.getPassword());
    props.put(AvailableSettings.DIALECT, settings.getDialect());
    props.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");

    sfb.addProperties(props);
    return sfb.buildSessionFactory();
  }

  @Bean
  public HibernateTransactionManager transactionManager() throws Exception {
    return new HibernateTransactionManager(sessionFactory());
  }

}
