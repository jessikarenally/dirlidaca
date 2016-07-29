package bootwildfly;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import org.hamcrest.Matchers;
import org.junit.Test;


public class UserControllerTest {
	
	
	@Test
	public void testLogin(){
		ValidatableResponse res = RestAssured.post("/user/login").then();
		res.statusCode(200);
	}
	
	@Test
	public void testPostUser(){
		ValidatableResponse res = RestAssured.post("/user").then();
		res.statusCode(201);
	}
	
	@Test
	public void testGetUserByUserId(){
		ValidatableResponse res = RestAssured.get("/user/1").then();
		res.statusCode(200);
		res.body("type",Matchers.hasItems("administrador"));
		res.body("name",Matchers.hasItems("Matheus"));
		res.body("email",Matchers.hasItems("Matheus@dsc.ufcg.edu.br"));
	}
	
	public void testDeleteUserByUserId(){
		ValidatableResponse res = RestAssured.delete("/user/1").then();
		res.statusCode(200);
	}
	
	public void testEditUserByUserId(){
		ValidatableResponse res = RestAssured.put("/user/1").then();
		res.statusCode(200);
	}

}
