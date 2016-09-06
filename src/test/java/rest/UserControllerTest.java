package rest;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.After;
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


@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest()
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

	private Gson gson;
	User user;
	long id ;
	@Autowired
	private UserController userController;

	@Before
	public void setUp(){
		gson = new Gson();
		user = new User("john", "j@j.com");
		id = userController.addUser(user).getBody().getId();
	}
	
	@After
	public void removeUser(){
		if(userController.getUser(user.getId()) != null){
			userController.deleteUser(user.getId());
		}
	}
	
	@Test
	public void testLogin() {
	}

	@Test
	public void testPostUser() {
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
		
		given()
			.accept("application/json")
			.pathParam("userId", id).
		when()
			.get("/user/{userId}").
		then()
			.assertThat().statusCode(is(200))
			.body("username", equalTo("john"))
			.body("email", equalTo("j@j.com"));
	}
	

	@Test
	public void testEditUserByUserId() {
		User newUser = new User("paul", "p@p.com");
		given()
			.contentType("application/json")
			.pathParam("userId", id)
			.body(gson.toJson(newUser)).
		when()
			.put("/user/{userId}").
		then()
			.assertThat().statusCode(is(200))
			.body("username", equalTo("paul"))
			.body("email", equalTo("p@p.com"));
	}
	
	
}

