package rest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class SolutionControllerTest {

	@Test
	public void testGetNonExistingSolution(){
		when().get("/solution/9999999").then().statusCode(404);
	}
	
	@Test
	public void testGetSolutionById(){
		ValidatableResponse res = RestAssured.get("/solution/1").then();
		res.statusCode(Matchers.equalTo(200));
		//TODO add a solution and check whether it can be retrieved
	}
	
	@Test
	public void testPostSolution(){
		String body  = "{}";
		Response res = given().contentType("application/json")
						.body(body)
						.when()
						.post("/solution");
		String resBody = res.body().asString();
		Assert.assertTrue(resBody.equals(body));
	}
	
}
