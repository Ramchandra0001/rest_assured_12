package pojo;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Shopper_runner {
	@Test
public void create() throws JsonProcessingException {
	String random = RandomStringUtils.randomAlphanumeric(5);
	String remail = "pandu"+random+"@gmail.com";
	Sopper_pojo ss=new Sopper_pojo();
	ss.setCity("Banglore");
	ss.setCountry("india");
	ss.setEmail(remail);
	ss.setFirstName("anivt");
	ss.setGender("male");
	ss.setLastName("gowda");
	ss.setPassword("anvi@123");
	ss.setPhone("348087892");
	ss.setState("karnataka");
	ss.setZoneId("ALPHA");
	ObjectMapper obj=new ObjectMapper();
	String jsonbody = obj.writerWithDefaultPrettyPrinter().writeValueAsString(ss);
	
		Response response = RestAssured.given().relaxedHTTPSValidation().body(jsonbody).contentType("application/json").when().
		post("https://www.shoppersstack.com/shopping/shoppers").then().extract().
	    response();
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
}
}
