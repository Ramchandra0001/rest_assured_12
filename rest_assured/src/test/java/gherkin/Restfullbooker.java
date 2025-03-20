package gherkin;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Restfullbooker {
@Test
public void create() {
RestAssured.given().relaxedHTTPSValidation().body("{\r\n"
		+ "    \"firstname\" : \"sacheeiion\",\r\n"
		+ "    \"lastname\" : \"b\",\r\n"
		+ "    \"totalprice\" : 111,\r\n"
		+ "    \"depositpaid\" : true,\r\n"
		+ "    \"bookingdates\" : {\r\n"
		+ "        \"checkin\" : \"2018-01-01\",\r\n"
		+ "        \"checkout\" : \"2019-01-01\"\r\n"
		+ "    },\r\n"
		+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
		+ "}").contentType("application/json").
when().post("https://restful-booker.herokuapp.com/booking").
then().assertThat().statusCode(200).log().all();

}
@Test
public void update()
{
RestAssured.given().auth().preemptive().basic("admin", "password123")
.body("{\r\n"
		+ "    \"firstname\" : \"James\",\r\n"
		+ "    \"lastname\" : \"Brown\",\r\n"
		+ "    \"totalprice\" : 111,\r\n"
		+ "    \"depositpaid\" : true,\r\n"
		+ "    \"bookingdates\" : {\r\n"
		+ "        \"checkin\" : \"2018-01-01\",\r\n"
		+ "        \"checkout\" : \"2019-01-01\"\r\n"
		+ "    },\r\n"
		+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
		+ "}").contentType("application/json").pathParam("id", "503").
when().put("https://restful-booker.herokuapp.com/booking/{id}").then().statusCode(200).log().all();

	
	
}
	
	
	
	
	
	
	
}
