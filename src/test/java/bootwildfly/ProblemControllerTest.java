package bootwildfly;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.expect;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ProblemControllerTest {

	@Test
	public void testGetProblemById() {
		ValidatableResponse res = RestAssured.get("/problem/1").then();
		res.statusCode(Matchers.equalTo(200));
		res.body("code", Matchers.equalTo(1));
		res.body("hint", Matchers.hasItems("DP"));
		res.body("name", Matchers.hasItems("kanpsack"));
		res.body("description",Matchers.hasItems("Fill the bag with maximizing the profit"));

	}
	@Test
	public void testNonExistingProblem() {
		when().get("/problem/99999999").then().statusCode(404);
	}

	@Test
	public void testGetProblem() {
		ValidatableResponse res = RestAssured.get("/problem").then();
		res.statusCode(Matchers.equalTo(200));
		res.body("problems.size()",Matchers.equalTo(0));
	}
	
	@Test
	public void testGetProblemSpecificSolution() {
		ValidatableResponse res = RestAssured.get("/problem/1/solution/1").then();
		res.statusCode(200);
		res.body("solution.body",Matchers.hasItems(""));
	}

	@Test
	public void testGetProblemSolutions() {
		ValidatableResponse res = RestAssured.get("/problem/1/solution").then();
		res.statusCode(200);
		res.body("solution.size()", Matchers.equalTo(0));
	}

	@Test
	public void testGetProblemSpecificTest() {
		ValidatableResponse res = RestAssured.get("/problem/test/1").then();
		res.statusCode(200);
		res.body("test.name",Matchers.hasItem(""));
		res.body("test.hint",Matchers.hasItem(""));
		res.body("test.input",Matchers.hasItem(""));
		res.body("test.expectedOutput",Matchers.hasItem(""));

	}

	@Test
	public void testGetProblemTests() {
		ValidatableResponse res = RestAssured.get("/problem/test").then();
		res.statusCode(200);
		res.body("test.size()",Matchers.equalTo(0));
	}

	@Test
	public void testgetProblemStatistics() {
		ValidatableResponse res = RestAssured.get("/problem/statistics").then();
		res.statusCode(200);
		res.body("statistics.size()",Matchers.equalTo(0));
	}
	
	@Test
	public void testPostProblemSolution(){
		String body = "{}";
		Response res = given().contentType("application/json")
								.body(body)
								.when()
								.post("/problem/123/solution");
		String resBody = res.body().asString();
		Assert.assertTrue(resBody.equals(body));
		
	}
	
	@Test
	public void testPostProblemTest(){
		String body = "{}";
		Response res = given().contentType("application/json")
								.body(body)
								.when()
								.post("/problem/123/test");
		String resBody = res.body().asString();
		Assert.assertTrue(resBody.equals(body));

	}

}
