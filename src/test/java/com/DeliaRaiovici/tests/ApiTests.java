package com.testautomation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {

    private String baseUrl;

    @BeforeClass
    public void setup() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        // Încarcă fișierul ca o resursă din classpath (din src/test/resources)
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("app.yaml");
        if (inputStream == null) {
            throw new IOException("Nu s-a putut găsi fișierul de configurare 'app.yaml' în src/test/resources");
        }

        JsonNode root = mapper.readTree(inputStream);
        this.baseUrl = root.path("service").path("baseUrl").asText();
    }

    @Test(description = "Verifică preluarea corectă a unei postări după ID")
    public void test_preluare_postare_dupa_id() {
        // ARRANGE
        String urlComplet = this.baseUrl + "/posts/1";
        System.out.println("Se testează endpoint-ul: " + urlComplet);

        // ACT & ASSERT
        given()
        .when()
            .get(urlComplet)
        .then()
            .assertThat()
            .statusCode(200)
            .body("id", equalTo(1)); 

        System.out.println("Testul API a trecut cu succes! Status 200 și ID corect.");
    }
}
