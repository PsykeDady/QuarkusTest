package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class GreetingResourceTest {


    @Test
    void assertTautologia () {
        assertTrue(true);
    }

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/bring")
          .then()
             .statusCode(200)
             .body(is("Bang Bang Born"));
    }

}