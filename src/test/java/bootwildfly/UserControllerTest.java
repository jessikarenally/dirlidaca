package bootwildfly;

import org.junit.Test;
import static io.restassured.RestAssured.*;


public class UserControllerTest {
	
	
	@Test
	public void testLogin(){
		when().
			post("/user/login")
		.then()
			.statusCode(200);
		
	}
	@Test
	public void testPostUser(){
		when().
			post("/user")
		.then()
			.statusCode(201);
		
	}
	
	@Test
	public void testGetUserByUserId(){
		when().
			get("/user/1")
		.then()
			.statusCode(200);
	}
	
	public void testDeleteUserByUserId(){
		when().
			delete("/user/1")
		.then()
			.statusCode(200);

	}
	
	public void testEditUserByUserId(){
		when().
			put("/user/1")
		.then()
			.statusCode(200);
	}

}
