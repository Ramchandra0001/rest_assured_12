package pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Restful_runner {
	
	
	@Test
	public void createbooking() throws JsonProcessingException {
	Rest_pojo rp=new Rest_pojo();
	rp.setFirstname("pooja");
	rp.setLastname("sheshadri");
	rp.setTotalprice(143);
	rp.setDepositpaid(true);

	Booking_dates_pojo bdp= new Booking_dates_pojo();
	bdp.setCheckin("2018-01-01");
	bdp.setCheckout("2019-01-01");
	rp.setBookingdates(bdp);
	rp.setAdditionalneeds("Breakfast");
	ObjectMapper obj=new ObjectMapper();
	String jsonbody = obj.writerWithDefaultPrettyPrinter().writeValueAsString(rp);
	System.out.println(jsonbody);
   
	Response response = RestAssured.given().body(jsonbody).contentType("application/json").when().
	post("https://restful-booker.herokuapp.com/booking").then().statusCode(200).extract().response();
	
	System.out.println(response.asPrettyString());
	System.out.println(response.statusCode());
	
	
	
	
	}
	
}
