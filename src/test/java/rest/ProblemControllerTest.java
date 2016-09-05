package rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Application;
import com.google.gson.Gson;
import com.model.Problem;
import com.model.ProblemTest;
import com.model.Solution;
import com.rest.ProblemController;
import com.rest.TestController;

@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest()
@RunWith(SpringJUnit4ClassRunner.class)
public class ProblemControllerTest {
	
	private Gson gson;
	private Problem problem; 
	
	@Autowired
	private ProblemController problemController;
	
	@Autowired
	private TestController testController;
	
	@Before
	public void setUp(){
		gson = new Gson();
		problem = new Problem("test2","test","nohint");
		problemController.deleteAll();
	}
	
	@Test
	public void testGetProblems() {
		Problem newProblem = new Problem("test3", "test3", "nohint3");
		problemController.saveProblem(newProblem);
		problemController.saveProblem(problem);
		
		given().
		when()
			.get("/problem")
		.then()
			.statusCode(is(200))
			.body("size()", is(2));	
	}

	@Test
	public void testPostProblem(){
		given()
			.contentType("application/json")
			.body(gson.toJson(problem))
		.when()
			.post("/problem").
		then()
			.statusCode(is(201))
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
			.statusCode(is(200))
			.body("name", is("test2"))
			.body("description", equalTo("test"));

	}
	@Test
	public void testNonExistingProblem() {
		long id = 9129391239L; //Non Existing Id
		given()
			.pathParam("problemId", id).
		when()
			.get("/problem/{problemId}").
		then()
			.statusCode(is(404));
	}

	@Test
	public void testPostProblemSolution(){
		int id = (int) problemController.saveProblem(problem).getBody().getId();
		Solution solution = new Solution("abc", "abc", "abc", true, id);
		given()
			.contentType("application/json")
			.pathParam("problemId", id)
			.body(gson.toJson(solution)).
		when()
			.post("/problem/{problemId}/solution").
		then()
			.statusCode(is(201))
			.body("solutionBody", equalTo("abc"))
			.body("givenOutput", equalTo("abc"))
			.body("givenInput", equalTo("abc"))
			.body("problemId", is(id));
	}
	
	@Test
	public void testGetProblemSpecificSolution() {
		int id = (int) problemController.saveProblem(problem).getBody().getId();
		Solution solution = new Solution("abc", "abc", "abc", true, id);
		int solutionId = (int) problemController.submitSolution(problem.getId(), solution).getBody().getId();
		
		given()
			.pathParam("problemId", id)
			.pathParam("solutionId", solutionId).
		when()
			.get("/problem/{problemId}/solution/{solutionId}").
		then()
			.statusCode(is(200))
			.body("solutionBody", equalTo("abc"))
			.body("givenOutput", equalTo("abc"))
			.body("givenInput", equalTo("abc"))
			.body("problemId", is(id));
	}

	@Test
	public void testGetProblemSolutions() {
		int id = (int) problemController.saveProblem(problem).getBody().getId();
		Solution solution1 = new Solution("abc", "abc", "abc", true, id);
		Solution solution2 = new Solution("cba", "cba", "cba", false, id);
		problemController.submitSolution(problem.getId(), solution1).getBody().getId();
		problemController.submitSolution(problem.getId(), solution2).getBody().getId();
		
		given()
			.pathParam("problemId", id).
		when()
			.get("/problem/{problemId}/solution").
		then()
			.body("size()", equalTo(2))
			.statusCode(200);
	}
	@Test
	public void testGetProblemSpecificTest() {
		ProblemTest test = new ProblemTest("testa soma", "teste os extremos", "2 + 2", "4", "public", 1);
		long id = testController.saveTest(test).getBody().getId();

		given()
			.pathParam("problemId", 1)
			.pathParam("testId", id)
		.when()
			.get("/problem/{problemId}/test/{testId}")
		.then()
			.statusCode(is(200))
			.body("name", is("testa soma"))
			.body("status", is("public"));

	}

	@Test
	public void testGetProblemTests() {
		ProblemTest test = new ProblemTest("testa1", "teste os extremos", "2 + 2", "4", "public", 2);
		ProblemTest test2 = new ProblemTest("testa2", "teste os extremos", "2 + 2", "4", "public", 2);
		testController.saveTest(test);
		testController.saveTest(test2);
		
		given()
			.pathParam("problemId", 2)
		.when()
			.get("/problem/{problemId}/test")
		.then()
			.statusCode(is(200))
			.body("size()", is(2));
	}
	
	@Test
	public void testCreateTestInProblem(){
		ProblemTest test = new ProblemTest("testa1", "teste os extremos", "2 + 2", "4", "public", 3);
		given()
			.body(test)
			.contentType("application/json")
			.body(gson.toJson(test))
			.pathParam("problemId", 9)
		.when()
			.post("/problem/{problemId}/test")
		.then()
			.statusCode(is(201))
			.body("name", is("testa1"));
	}

/*
	@Test
	public void testgetProblemStatistics() {
		ValidatableResponse res = RestAssured.get("/problem/statistics").then();
		res.statusCode(200);
		res.body("statistics.size()",Matchers.equalTo(0));
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
