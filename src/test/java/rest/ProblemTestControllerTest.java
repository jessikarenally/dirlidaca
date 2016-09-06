package rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Application;
import com.auth.UserLogin;
import com.google.gson.Gson;
import com.model.test.ProblemTest;
import com.model.user.User;
import com.rest.test.TestController;
import com.rest.user.UserController;

@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest()
@RunWith(SpringJUnit4ClassRunner.class)
public class ProblemTestControllerTest {

	private Gson gson;
	ProblemTest test;
	@Autowired
	TestController testController;
	@Autowired
	private UserController userController;
	private String token;
	private User user;
	
	
	@Before
	public void setUp(){
		gson = new Gson();
		test = new ProblemTest("testa soma", "teste os extremos", "2 + 2", "4", "public", 1);
		testController.deleteAll();
		user = new User("joao", "joao","joao");
		userController.addUser(user);
		UserLogin login = new UserLogin(user.getUsername(),user.getPassword());
		token = userController.login(login).getBody().getToken();
		gson = new Gson();
	}
	
	@After
	public void removeUser(){
		userController.deleteUser(user.getId());
	}
	
	@Test
	public void testNonExistingTest(){
		long id = 9129391239L; //Non Existing Id

		given().header("Authorization",token)
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

		given().header("Authorization",token)
			.pathParam("testId", id)
		.when()
			.get("/test/{testId}")
		.then()
			.statusCode(is(200))
			.body("name", is("testa soma"))
			.body("status", is("public"));
	}
	
	@Test
	public void testGetTestS(){
		ProblemTest test2 = new ProblemTest("testa2", "teste os extremos", "2 + 2", "4", "public", 2);
		testController.saveTest(test);
		testController.saveTest(test2);
		
		given().header("Authorization",token)
		.when()
			.get("/test")
		.then()
			.statusCode(is(200))
			.body("size()", is(2));
	}
	
	
	@Test
	public void testPostTest(){
		given().header("Authorization",token)
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

		given().header("Authorization",token)
			.pathParam("testId", id)
		.when()
			.delete("/test/{testId}")
		.then()
			.statusCode(is(200));
	}
}
