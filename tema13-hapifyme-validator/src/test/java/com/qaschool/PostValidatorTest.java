package com.qaschool;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostValidatorTest {

    private PostValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new PostValidator();
    }

    @DataProvider(name = "postDataProvider")
    public Object[][] postDataProvider() {
        return new Object[][] {
                {"Acesta este un post valid", "POST_VALID"},
                {null, "ERROR_EMPTY"},
                {"", "ERROR_EMPTY"},
                {"Acest post vorbeste despre politica.", "ERROR_FORBIDDEN"},
                {"Un post foarte lung care depaseste limita de caractere...".repeat(10), "ERROR_TOO_LONG"}
        };
    }

    @Test(dataProvider = "postDataProvider")
    public void testPostValidationScenarios(String postBody, String expectedStatus) {
        String actualStatus = validator.getPostStatus(postBody);
        Assert.assertEquals(actualStatus, expectedStatus,
                "Statusul postarii nu este cel așteptat pentru input: " + postBody);
    }
}