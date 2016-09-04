package rest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.restassured.response.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Application;
import com.google.gson.Gson;
import com.model.ProblemTest;
import com.rest.TestController;

@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest()
@RunWith(SpringJUnit4ClassRunner.class)
public class ProblemTestControllerTest {

	private Gson gson;
	ProblemTest test;
	
	@Autowired
	TestController testController;
	
	@Before
	public void setUp(){
		gson = new Gson();
		test = new ProblemTest("testa soma", "teste os extremos", "2 + 2", "4", "public", 1);
	}

	@Test
	public void testNonExistingTest(){
		long id = 9129391239L; //Non Existing Id

		given()
			.pathParam("testId", id)
		.when()
			.get("/test/{testId}")
		.then()
			.statusCode(is(404));
	}
	
	@Test
	public void testGetTestById(){
		ProblemTest test = new ProblemTest("testa soma", "teste os extremos", "2 + 2", "4", "public", 1);
		long id = testController.saveTest(test).getBody().getId();

		given()
			.pathParam("testId", id)
		.when()
			.get("/test/{testId}")
		.then()
			.statusCode(is(200))
			.body("name", is("testa soma"))
			.body("status", is("public"));
	}
	
	@Test
	public void testGetTest(){
		ProblemTest test2 = new ProblemTest("testa2", "teste os extremos", "2 + 2", "4", "public", 2);
		testController.saveTest(test);
		testController.saveTest(test2);
		
		given()
		.when()
			.get("/test")
		.then()
			.statusCode(is(200))
			.body("size()", is(2));

	}
	
	
	@Test
	public void testPostTest(){
		given()
			.body(test)
			.contentType("application/json")
			.body(gson.toJson(test)).
		when()
			.post("/test").
		then()
			.statusCode(is(201))
			.body("name", is("testa soma"))
			.body("status", equalTo("public"));
	}
	
	@Test
	public void testRemoveTestById(){
		ProblemTest test = new ProblemTest("testa soma", "teste os extremos", "2 + 2", "4", "public", 1);
		long id = testController.saveTest(test).getBody().getId();

		given()
			.pathParam("testId", id)
		.when()
			.delete("/test/{testId}")
		.then()
			.statusCode(is(200));
	}
}
