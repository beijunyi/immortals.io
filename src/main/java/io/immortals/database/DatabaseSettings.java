package io.immortals.database;

import javax.annotation.Nonnull;

import io.immortals.AbstractSettings;
import io.immortals.AppBase;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.RandomStringUtils;
import org.h2.Driver;
import org.hibernate.dialect.H2Dialect;

import static org.apache.commons.io.FilenameUtils.concat;

public class DatabaseSettings extends AbstractSettings {

  private static final String DATABASE_HOME = concat(AppBase.APP_HOME, "database");
  private static final String DATABASE_SETTINGS_FILE = concat(DATABASE_HOME, "settings.properties");

  public DatabaseSettings() {
    super(DATABASE_SETTINGS_FILE);
  }

  @Override
  protected void defaultSettings(@Nonnull Configuration config) {
    config.setProperty(Key.DRIVER.name(), Driver.class.getCanonicalName());
    config.setProperty(Key.URL.name(), "jdbc:h2:file:" + concat(DATABASE_HOME, "data"));
    config.setProperty(Key.USERNAME.name(), AppBase.APP_NAME);
    config.setProperty(Key.PASSWORD.name(), RandomStringUtils.randomAlphanumeric(16));
    config.setProperty(Key.DIALECT.name(), H2Dialect.class.getCanonicalName());
  }

  @Nonnull
  public String getDriver() {
    return config.getString(Key.DRIVER.name());
  }

  @Nonnull
  public String getUrl() {
    return config.getString(Key.URL.name());
  }

  @Nonnull
  public String getUsername() {
    return config.getString(Key.USERNAME.name());
  }

  @Nonnull
  public String getPassword() {
    return config.getString(Key.PASSWORD.name());
  }

  @Nonnull
  public String getDialect() {
    return config.getString(Key.DIALECT.name());
  }

  public static enum Key {
    DRIVER,
    URL,
    USERNAME,
    PASSWORD,
    DIALECT
  }
}
