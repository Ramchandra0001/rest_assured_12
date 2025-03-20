package spec_builder;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Spec_builder1 {
    @BeforeMethod
    
    public RequestSpecification reqest(String url, String body, String content) 
    {
    	RequestSpecBuilder s=new RequestSpecBuilder();
    	RequestSpecification req = s.setBaseUri(url).setBody(body).setContentType(content).build();
    	return req;
    }
	
    @AfterMethod
    public ResponseSpecification response(int code,String line, long time) 
    {
    	ResponseSpecBuilder s=new ResponseSpecBuilder();
    	ResponseSpecification res = s.expectStatusCode(code).expectStatusLine(line).
    			expectResponseTime(Matchers.lessThanOrEqualTo(time)).build();
    	return res;
    }
   
    @BeforeMethod
    public RequestSpecification request2(String url) 
    {
    	RequestSpecBuilder s= new RequestSpecBuilder();
    	RequestSpecification req=s.setBaseUri(url).build();
    	return req;
    }
}
