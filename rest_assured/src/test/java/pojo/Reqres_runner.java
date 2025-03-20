package pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Reqres_runner {
@Test
public void post() throws JsonProcessingException {
	Reqres_pojo rp=new Reqres_pojo();
	rp.setName("morpheous");
	rp.setJob("leader");
	
	ObjectMapper obj=new ObjectMapper();
	String jsonbody = obj.writerWithDefaultPrettyPrinter().writeValueAsString(rp);
	 
	
	
	Response response = RestAssured.given().body(jsonbody).contentType("application/json").when().
	post("https://reqres.in/api/users").then().statusCode(201).
	extract().response();
	JsonPath js=new JsonPath(response.asPrettyString());
	String sam = js.getString("name");
	System.out.println(sam);
	
	
}

	
	
	
	
	
	
	
	
	
	
	
}
