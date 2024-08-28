package com.gft.test.inditex.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.gft.test.inditex.infrastructure.controller.response.PriceResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetPriceAt10AMOn14th() {
        String url = "http://localhost:" + port
                + "/api/v1/price?brandId=1&productId=35455&applicationDate=2020-06-14T10:00:00";

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url, PriceResponse.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, new BigDecimal("35.50").compareTo(response.getBody().getPrice()));
    }

    @Test
    public void testGetPriceAt4PMOn14th() {
        String url = "http://localhost:" + port
                + "/api/v1/price?brandId=1&productId=35455&applicationDate=2020-06-14T16:00:00";

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url, PriceResponse.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, new BigDecimal("25.45").compareTo(response.getBody().getPrice()));
    }

    @Test
    public void testGetPriceAt9PMOn14th() {
        String url = "http://localhost:" + port
                + "/api/v1/price?brandId=1&productId=35455&applicationDate=2020-06-14T21:00:00";

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url, PriceResponse.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, new BigDecimal("35.50").compareTo(response.getBody().getPrice()));
    }

    @Test
    public void testGetPriceAt10AMOn15th() {
        String url = "http://localhost:" + port
                + "/api/v1/price?brandId=1&productId=35455&applicationDate=2020-06-15T10:00:00";

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url, PriceResponse.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, new BigDecimal("30.50").compareTo(response.getBody().getPrice()));
    }

    @Test
    public void testGetPriceAt9PMOn16th() {
        String url = "http://localhost:" + port
                + "/api/v1/price?brandId=1&productId=35455&applicationDate=2020-06-16T21:00:00";

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url, PriceResponse.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, new BigDecimal("38.95").compareTo(response.getBody().getPrice()));
    }
}