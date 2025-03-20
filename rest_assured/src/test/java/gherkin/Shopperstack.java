package gherkin;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Shopperstack {
	@Test
	public void register() {

		String alphanumeric = RandomStringUtils.randomAlphanumeric(4);
		String randomemail = "ram" + alphanumeric + "@gmail.com";
		System.out.println(randomemail);

		Response resp = RestAssured.given().relaxedHTTPSValidation()
				.body("{\r\n" + "  \"city\": \"bang\",\r\n" + "  \"country\": \"india\",\r\n" + "  \"email\": \""
						+ randomemail + "\",\r\n" + "  \"firstName\": \"ram\",\r\n" + "  \"gender\": \"MALE\",\r\n"
						+ "  \"lastName\": \"patil\",\r\n" + "  \"password\": \"123@Ram\",\r\n"
						+ "  \"phone\": 8105457251,\r\n" + "  \"state\": \"karnataka\",\r\n"
						+ "  \"zoneId\": \"ALPHA\"\r\n" + "}")
				.contentType("application/json").when().post("https://www.shoppersstack.com/shopping/shoppers").then()
				.assertThat().statusCode(201).extract().response();

		System.out.println(resp.asPrettyString());
		JsonPath jp = new JsonPath(resp.asPrettyString());
		String mess = jp.getString("message");
		System.out.println(mess);

		String email = jp.getString("data.email");
		System.out.println(email);

	}

	@Test
	public void login() {
		RestAssured.given().relaxedHTTPSValidation()
				.body("{\r\n" + "  \"email\": \"ram123rampat@gmail.com\",\r\n" + "  \"password\": \"123@Ram\",\r\n"
						+ "  \"role\": \"SHOPPER\"\r\n" + "}")
				.contentType("application/json").when().post("https://www.shoppersstack.com/shopping/users/login")
				.then().assertThat().statusCode(200).log().all();
	}

	@Test
	public void getshoppeid() {
		RestAssured.given().relaxedHTTPSValidation().pathParam("shopperId", "226400").auth().oauth2(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYW0xMjNyYW1wYXRAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3NDI0MjU0MzIsImlhdCI6MTc0MjM4OTQzMn0.uWadSqDmYjA_YFArPZL9PVR26Bpq3jJ1-kFcb_ucpM4")
				.when().get("https://www.shoppersstack.com/shopping/shoppers/{shopperId}").then().assertThat()
				.statusCode(200).log().all();
	}

	// @Test//
	public void patch1() {
		RestAssured.given().relaxedHTTPSValidation().pathParam("shopperId", "226400");
		
	
	   
		
	
	
	
		}
	
	

		
}
