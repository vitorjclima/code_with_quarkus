package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class FruitResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(404);
    }

    @Test
    public void testFruitsEndpoint() {
        given()
                .when().get("/fruits")
                .then()
                .statusCode(200)
                .body(is("[{\"description\":\"Winter fruit\",\"name\":\"Apple\"},{\"description\":\"Tropical fruit\",\"name\":\"Pineapple\"}]"));
    }

}