package io.immortals;

import java.io.File;
import javax.annotation.Nonnull;

import org.apache.commons.configuration.AbstractFileConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

public abstract class AbstractSettings {

  protected final AbstractFileConfiguration config;

  protected AbstractSettings(@Nonnull String path) {
    try {
      File file = new File(path);
      config = new PropertiesConfiguration(file);
      if(!file.exists()) {
        defaultSettings(config);
        config.save();
      } else
        config.load();
      config.setAutoSave(true);
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }

  protected abstract void defaultSettings(@Nonnull Configuration config);

}
