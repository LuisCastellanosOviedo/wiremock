package co.com.mocks.salaryloans.onbase;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.matchingXPath;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import co.com.mocks.common.ADLCommonMockFramework;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;


class POP5553AllDocumentsWithoutValidity extends ADLCommonMockFramework {

	@Test
	void SC_001_shouldReturnAllAllDocuments() {
		stubFor(post(urlEqualTo("/busicapa/onbase/documents/query"))
				.withHeader("Content-Type", equalTo(MediaType.APPLICATION_JSON.toString()))
				.willReturn(aResponse()
						.withHeader("Content-Type", "application/json")
						.withBody(readFileAsString(
								"mocks/Salaryloans/onbase/rest/POP-4435-shoudReturnAllFields.json"))));

	}

	@Test
	void SC_001_SOAP_shouldReturnAllAllDocuments() {
		stubFor(post(urlEqualTo("/prodschnsmngt/OnBaseProdsChnsMngt"))
				.withHeader("Content-Type", equalTo("text/xml"))
				.withRequestBody(matchingXPath("/Envelope/Body/setOnbaseProdsChnsMngtRequest/OnBaseProdsChnsMngtRq[RqUID = 15520149]"))
				.willReturn(aResponse()
						.withHeader("Content-Type", "text/xml")
						.withBody(readFileAsString(
								"mocks/Salaryloans/onbase/soap/POP-4435-shouldReturnAllFieldsFromBPOP.xml"))));

	}

}
