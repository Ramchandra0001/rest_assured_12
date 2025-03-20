package gherkin;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Reqres {
	@Test
	public void post()
	{
		RestAssured.given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\",\r\n"
				+ "    \"id\": \"780\",\r\n"
				+ "    \"createdAt\": \"2025-03-05T12:46:11.603Z\"\r\n"
				+ "}").contentType("application/json").
		when().post("https://reqres.in/api/users").
		then().assertThat().statusCode(201).log().all();
	}
	 @Test
	 public void sir() 
	 {
		 RestAssured.given().when().get();
		 
		 
	 }
	
	
	
	
	
	
	
	@Test
	public void get()
	{
	RestAssured.given().
	when().get("https://reqres.in/api/users/2").
	then().assertThat().statusCode(200).log().all();
	}
	
	@Test
	public void put()
	{
		RestAssured.given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").contentType("application/json").
		when().put("https://reqres.in/api/users/2").
		then().assertThat().statusCode(200).log().all();
		
		
	}
	
	
	
}
