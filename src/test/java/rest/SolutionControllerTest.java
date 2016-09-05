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
import com.model.Solution;
import com.model.User;
import com.rest.ProblemController;
import com.rest.SolutionController;
import com.rest.UserController;


@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest()
@RunWith(SpringJUnit4ClassRunner.class)
public class SolutionControllerTest {
	
	private Gson gson;
	private Solution solution;
	@Autowired
	private SolutionController solutionController;
	@Autowired
	private ProblemController problemController;
	@Autowired
	private UserController userController;

	
	@Before
	public void setUp(){
		solution = new Solution("abc", "abc", "abc", true, 1);
		gson = new Gson();
	}

	@Test
	public void testGetNonExistingSolution(){
		long id = 9129391239L; //Non Existing Id
		given()
			.pathParam("solutionId", id).
		when()
			.get("/solution/{solutionId}").
		then()
			.statusCode(is(404));
	}
	
	@Test
	public void testGetSolutionById(){
		long id = problemController.submitSolution(1L, solution).getBody().getId();
		given()
			.contentType("application/json")
			.pathParam("solutionId", id)
		.when()
			.get("/solution/{solutionId}")
		.then()
			.statusCode(is(200))
			.body("solutionBody", is("abc"))
			.body("givenOutput", equalTo("abc"));
	}
	
	@Test
	public void testGetUserSolution(){
		User user = new User("john", "j@j.com");
		long id = userController.addUser(user).getBody().getId();
		given()
			.contentType("application/json")
			.pathParam("userId", id)
		.when()
			.get("/solution/user/{userId}")
		.then()
			.statusCode(is(200))
			.body("size()", is(0));
	}
	
	@Test
	public void testDeleteSolution(){
		long id = problemController.submitSolution(1L, solution).getBody().getId();
		given()
			.contentType("application/json")
			.pathParam("solutionId", id)
		.when()
			.delete("/solution/{solutionId}")
		.then()
			.statusCode(is(200));
		//check it's really gone
		given()
			.contentType("application/json")
			.pathParam("solutionId", id)
		.when()
			.get("/solution/{solutionId}")
		.then()
			.statusCode(is(404));
	}
	
	@Test
	public void testEditSolution(){
		long id = problemController.submitSolution(1L, solution).getBody().getId();
		Solution newSolution = new Solution("teste", "teste", "teste", false, 1);
		
		given()
			.contentType("application/json")
			.pathParam("solutionId", id)
			.body(gson.toJson(newSolution))
		.when()
			.put("/solution/{solutionId}")
		.then()
			.statusCode(is(200))
			.body("solutionBody", equalTo("teste"));
	}
	
}
