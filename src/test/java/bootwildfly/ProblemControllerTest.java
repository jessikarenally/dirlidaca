package bootwildfly;

import org.junit.Test;
import static io.restassured.RestAssured.*;



public class ProblemControllerTest {
	
	
	@Test	
	public void testGetProblem(){
		when()
			.get("/problem").
		then()
			.statusCode(200);
			
	}
	
	@Test	
	public void testGetProblemId(){
		when()
			.get("/problem/1").
		then()
			.statusCode(200);
			
	}
	
	@Test	
	public void testGetProblemSpecificSolution(){
		when()
			.get("/problem/1/solution/1").
		then()
			.statusCode(200);
			
	}
	
	@Test	
	public void testGetProblemSolutions(){
		when()
			.get("/problem/1/solution").
		then()
			.statusCode(200);
			
	}

	@Test	
	public void testGetProblemSpecificTest(){
		when()
			.get("/problem/test/1").
		then()
			.statusCode(200);
			
	}
	
	@Test	
	public void testGetProblemTests(){
		when()
			.get("/problem/test").
		then()
			.statusCode(200);
			
	}
	
	@Test
	public void testgetProblemStatistics(){
		when()
			.get("/problem/statistics").
		then()
		.	statusCode(200);
		
	}
	
	
	

}
