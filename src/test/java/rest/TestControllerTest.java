package rest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class TestControllerTest {

	@Test
	public void testNonExistingTest(){
		when().get("/test/99999999").then().statusCode(404);
	}
	
	@Test
	public void testGetTestById(){
		ValidatableResponse res = RestAssured.get("test/1").then();
		res.statusCode(Matchers.equalTo(200));
		res.body("",Matchers.equalTo(""));
		res.body("",Matchers.equalTo(""));
		res.body("",Matchers.equalTo(""));
		res.body("",Matchers.equalTo(""));
	}
	
	
	@Test
	public void testPostTest(){
		String body  = "{}";
		Response res = given().contentType("application.json")
								.body(body)
								.when()
								.post("/test");
		String resBody = res.body().asString();
		Assert.assertTrue(resBody.equals(body));
	}
}
