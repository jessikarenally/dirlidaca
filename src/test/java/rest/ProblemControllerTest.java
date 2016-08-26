package rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import com.model.Problem;

public class ProblemControllerTest {

	@Test
	public void testPostProblem(){
		Problem problem = new Problem("teste2",null,null,1234);
		given()
			.body(problem)
			.contentType("application/json")
		.when()
			.post("/problem")
		.then()
			.assertThat().statusCode(is(201))
			.body("name", is("teste2"))
			.body("code", is(1234));
	}
	
	@Test
	public void testGetProblemById() {
		//Problem problem = new Problem("teste",null,null,123);
		given()
			.contentType("application/json")
		.when()
			.get("/problem/123")
		.then()
			.assertThat()
			.statusCode(is(200))
			.body("name", is("teste"))
			.body("code", is(123));

	}
	/*
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
*/
}
