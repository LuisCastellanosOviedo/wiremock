package co.com.mocks.common;

import co.com.mocks.common.util.ReadFromFile;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.BeforeEach;

public class ADLCommonMockFramework {

  @BeforeEach
  void setUp() {
    WireMock.configureFor("localhost", 8080);
  }

  public static String readFileAsString(String file)
  {
    return ReadFromFile.readFileAsString(file);
  }

}
