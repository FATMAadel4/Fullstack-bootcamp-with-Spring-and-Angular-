package com.adminPanel.app.controller;
import com.adminPanel.app.DTO.ProductDetailsDTO;
import com.adminPanel.app.model.ProductDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

    import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
    import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
    public class ProductRestTemplate {

        @Autowired
        private RestTemplate restTemplate;
        private final String baseUrl = "http://localhost:8080";

        // -------- GET all products --------
        @Test
        public void testGetAllProducts() {
            ResponseEntity<Object[]> response = restTemplate.getForEntity(baseUrl + "/products", Object[].class);
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
        }

        // -------- GET product by ID --------
        @Test
        public void testGetProductById() {
            int testId = 1;
            ResponseEntity<Object> response = restTemplate.getForEntity(baseUrl + "/products/" + testId, Object.class);
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
        }

        // -------- POST product-details --------
        @Test
        public void testInsertProductDetails() {
            ProductDetails details = new ProductDetails();
            details.setId(100);
            details.setName("Test Product");
            details.setExpirationDate(new Date());
            details.setManufacturer("Updated Manufacturer");
            details.setPrice(150.0);
            details.setAvailable(true);


            ResponseEntity<ProductDetails> response = restTemplate.postForEntity(
                    baseUrl + "/product-details",
                    request,
                    ProductDetails.class
            );

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
            assertEquals("Test Product", response.getBody().getName());
        }

        // -------- PUT product-details --------
        @Test
        public void testUpdateProductDetails() {
            ProductDetails details = new ProductDetails();
            details.setId(100);
            details.setName("Updated Product");
            details.setExpirationDate(new Date());
            details.setManufacturer("Updated Manufacturer");
            details.setPrice(150.0);
            details.setAvailable(true);


            ResponseEntity<ProductDetailsDTO> response = restTemplate.exchange(
                    baseUrl + "/product-details",
                    HttpMethod.PUT,
                    request,
                    ProductDetailsDTO.class
            );

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
            assertEquals("Updated Product", response.getBody().getName());
        }

        // -------- DELETE product-details --------
        @Test
        public void testDeleteProductDetails() {
            int deleteId = 100;

            ResponseEntity<Void> response = restTemplate.exchange(
                    baseUrl + "/product-details/" + deleteId,
                    HttpMethod.DELETE,
                    null,
                    Void.class
            );

            assertEquals(HttpStatus.OK, response.getStatusCode());


        }

        // -------- GET product-details by Name --------
        @Test
        public void testGetProductDetailsByName() {
            String name = "Test Product";
            ResponseEntity<ProductDetailsDTO> response = restTemplate.getForEntity(
                    baseUrl + "/product-details/name/" + name,
                    ProductDetailsDTO.class
            );

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
            assertEquals(name, response.getBody().getName());
        }
    }

}