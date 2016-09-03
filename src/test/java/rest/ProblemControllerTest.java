package rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.*;

import com.Application;
import com.google.gson.Gson;
import com.model.Problem;
import com.rest.ProblemController;

@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest()
@RunWith(SpringJUnit4ClassRunner.class)
public class ProblemControllerTest {
	
	private Gson gson;
	private Problem problem; 
	
	@Autowired
	private ProblemController problemController;
	
	@Before
	public void setUp(){
		gson = new Gson();
		problem = new Problem("test2","test","nohint");
	}

	@Test
	public void testPostProblem(){
		given()
			.body(problem)
			.contentType("application/json")
			.body(gson.toJson(problem)).
		when()
			.post("/problem").
		then()
			.assertThat().statusCode(is(201))
			.body("name", is("test2"))
			.body("hint", equalTo("nohint"));
	}
	
	@Test
	public void testGetProblemById() {
		long id = problemController.saveProblem(problem).getBody().getId();
		
		given()
			.contentType("application/json")
			.pathParam("problemId", id)
		.when()
			.get("/problem/{problemId}")
		.then()
			.assertThat()
			.statusCode(is(200))
			.body("name", is("test2"))
			.body("description", equalTo("test"));

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
