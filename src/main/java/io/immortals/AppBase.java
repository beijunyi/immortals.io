package io.immortals;

import static org.apache.commons.io.FileUtils.getUserDirectoryPath;
import static org.apache.commons.io.FilenameUtils.concat;

public final class AppBase {

  public static final String USER_HOME = getUserDirectoryPath();

  public static final String APP_NAME = "immortals.io";
  public static final String APP_HOME = System.getProperty(APP_NAME, concat(USER_HOME, APP_NAME));

}
