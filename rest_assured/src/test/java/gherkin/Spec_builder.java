package gherkin;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Spec_builder {
@Test
public void post()
{
	RestAssured.given().body("{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"leader\"\r\n"
			+ "}").contentType("application/json").when().post("https://reqres.in/api/users").
then().assertThat().statusCode(201).and().statusLine("HTTP/1.1 201 Created").and().time(Matchers.lessThanOrEqualTo(8000l)).
and().body("name", Matchers.equalTo("morpheus")).and().header("server", Matchers.equalTo("cloudflare")).log().all();
}
}
