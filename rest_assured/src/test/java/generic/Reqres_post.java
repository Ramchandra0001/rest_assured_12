package generic;
import java.io.IOException;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import property_file.Get_property;
import spec_builder.Spec_builder1;
public class Reqres_post {
@Test
public void post() throws IOException {
	Get_property gp=new Get_property();
	String url = gp.get("url");
	String endpoint = gp.get("postendpoint");
	
	Spec_builder1 s=new Spec_builder1();
	RequestSpecification req = s.reqest(url, "{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"leader\"\r\n"
			+ "}", "application/json");
	ResponseSpecification res = s.response(201, "HTTP/1.1 201 Created", 33000l);
	
	Response response = RestAssured.given().spec(req).when().
	post(endpoint).then().spec(res).extract().response();
	System.out.println(response.asPrettyString());
}
}
