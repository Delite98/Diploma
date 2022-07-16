package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import configurations.ApiEndpoints;
import io.restassured.response.Response;
import models.Project;
import models.Suits;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTests extends BaseApiTest {
    int idProject = 148;

    @Test
    public void postProjectApiTest() {
        Project newProject = Project.builder()
                .name("API test from API test")
                .announcement("Hi, I'm test api for diploma")
                .build();

        given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\"\n" +
                        "}", newProject.getName()))
                .when()
                .post(ApiEndpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void postSuiteApiTest() {
        Suits newSuits = Suits.builder()
                .name("SuitsMyGod0")
                .description("Hello, let's try")
                .build();

        given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\"\n" +
                        "}", newSuits.getName()))
                .when()
                .pathParam("project_id", idProject)
                .post(ApiEndpoints.ADD_SUITES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getProjectsApiTest() {
        given()
                .when()
                .get(ApiEndpoints.GET_PROJECTS)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getReportsApiTest() {
        given()
                .when()
                .pathParam("project_id", idProject)
                .get(ApiEndpoints.GET_REPORTS)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getSuitesApiTest() {
        given()
                .when()
                .pathParam("project_id", idProject)
                .get(ApiEndpoints.GET_SUITES)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getPlansApiTest() {
        given()
                .when()
                .pathParam("project_id", idProject)
                .get(ApiEndpoints.GET_PLANS)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(expectedExceptions = {AssertionError.class})
    public void incorrectValidateApiTest() {
        Response response = given()
                .pathParam("project_id", idProject)
                .get(ApiEndpoints.GET_PROJECT);

        Project actualProject = new Gson().fromJson(response.getBody().asString(),
                Project.class);

        Assert.assertEquals(actualProject.getName(), "Name of Project for API test");
    }
}
