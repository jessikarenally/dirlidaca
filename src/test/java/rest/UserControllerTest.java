package rest;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Application;
import com.google.gson.Gson;
import com.model.User;
import com.rest.UserController;
import static org.hamcrest.Matchers.*;


@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest()
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

	private Gson gson;
	@Autowired
	private UserController userController;

	@Before
	public void setUp() throws Exception {
		gson = new Gson();
	}

	@Test
	public void testLogin() {
	}

	@Test
	public void testPostUser() {
		User user = new User("john", "j@j.com");
		given()
			.contentType("application/json")
			.body(gson.toJson(user)).
		when()
			.post("/user").
		then()
			.assertThat().statusCode(is(201));
	}

	@Test
	public void testGetUserByUsername() {
		User user = new User("john", "j@j.com");
		long id = userController.addUser(user).getBody().getId();
		
		given()
			.accept("application/json")
			.pathParam("userId", id).
		when()
			.get("/user/{userId}").
		then()
			.assertThat().statusCode(is(200));
		//TODO check body response
	}

	public void testDeleteUserByUserId() {
		
	}

	public void testEditUserByUserId() {
		User user = new User("john", "j@j.com");
		User newUser = new User("paul", "j@j.com");
		long id = userController.addUser(user).getBody().getId();
		
		given()
			.accept("application/json")
			.pathParam("userId", id)
			.body(newUser).
		when()
			.put("/user/{userId}").
		then()
			.assertThat().statusCode(is(200)).
			 and().assertThat().body("username", equalTo("paul"));
	}
}
