package co.com.mocks.helloWorld;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import co.com.mocks.common.ADLCommonMockFramework;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

public class HelloWorldTest extends ADLCommonMockFramework {

  @Test
  public void shouldReturnHelloWorld() {
    stubFor(get(urlEqualTo("/some/thing"))
        .withHeader("Content-Type", equalTo(MediaType.TEXT_PLAIN.toString()))
        .willReturn(aResponse()
            .withHeader("Content-Type", "text/plain")
            .withBody("Hello world!")));
  }
}
