package com.gft.test.inditex.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.gft.test.inditex.infrastructure.controller.response.PriceResponse;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriceStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<PriceResponse> response;

    @When("a user requests the price for brand {long}, product {long} at {string}")
    public void aUserRequestsThePriceForBrandProductAt(Long brandId, Long productId, String date) {
        String url = String.format("/price?brandId=%d&productId=%d&applicationDate=%s", brandId, productId, date);
        response = restTemplate.getForEntity(url, PriceResponse.class);
    }

    @Then("the system returns a price list {int} with a price of {double}")
    public void theSystemReturnsAPriceListWithAPriceOf(Integer priceList, Double price) {
        PriceResponse priceResult = response.getBody();
        assertEquals(priceList, priceResult.getPriceList());
        assertEquals(price, priceResult.getPrice().doubleValue());
    }
}
