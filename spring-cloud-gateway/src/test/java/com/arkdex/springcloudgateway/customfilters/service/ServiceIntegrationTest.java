package com.arkdex.springcloudgateway.customfilters.service;

import com.arkdex.springcloudgateway.customfilters.service.web.ServiceRestController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(ServiceRestController.class)
public class ServiceIntegrationTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void whenResourceEndpointCalled_thenRetrievesResourceStringWithContentLanguageHeader() throws Exception {
        this.webClient.get()
            .uri("/resource")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .valueEquals(HttpHeaders.CONTENT_LANGUAGE, "en")
            .expectBody(String.class)
            .isEqualTo("Service Resource");
    }
}
