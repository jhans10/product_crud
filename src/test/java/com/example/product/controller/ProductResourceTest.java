package com.example.product.controller;

import com.example.product.model.Product;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ProductResourceTest {

    @Test
    void testCreateProduct() {
        Product p = new Product();
        p.name = "Laptop";
        p.price = new java.math.BigDecimal("1200.00");
        p.description = "Laptop de alto rendimiento";

        given()
                .contentType(ContentType.JSON)
                .body(p)
                .when().post("/api/products")
                .then()
                .statusCode(201);
    }
}