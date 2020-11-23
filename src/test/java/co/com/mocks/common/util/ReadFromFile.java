package co.com.mocks.common.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromFile {

  public static final String SRC_TEST_RESOURCES = "src/test/resources/";

  public static String readFileAsString(String file)
  {
    String fromFile= SRC_TEST_RESOURCES;
    try {
      fromFile =  new String(Files.readAllBytes(Paths.get(fromFile+file)));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return fromFile;
  }

}
