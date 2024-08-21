package stepDef;

import org.junit.Assert;
import org.junit.Test;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import urls.urlss;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class postAPI {

	RequestSpecification request;
    Response response;
//	RequestSpecification postrequest;
//	Response postresponse;
//	RequestSpecification getrequest;
//	Response getresponse;
//	RequestSpecification unknowngetrequest;
//	Response unknowngetresponse;
	 static String ids; 

	private static final Logger logger = LogManager.getLogger(postAPI.class);
	
//	 @Test
//	    public void sequentialExecution() {
//	        postRequest();
//	        getRequest();
//	        unknownRequest();
//	    }

	@Test
	public void AunknownRequest()
	{
		//		create post prerequest script 
		RestAssured.baseURI=urlss.baseUrl.endpoint();
		request=RestAssured.given().log().all().header("Content-Type",ContentType.JSON).body(payload.postrequest.payloads());

		//		execute post api
		response = request.when().post(urlss.createpostapi.endpoint());
		//		validate the 201 response code
		response.then().log().all().assertThat().statusCode(201);
		//		validate the response id is matching with expected result 
		response.then().body("job", equalTo("leader"));
		//		retrieve the ID values
		ids = response.jsonPath().getString("id");
		System.out.println("print the id value" +ids);
		//		print the value id value using log4j2
		logger.info("print the i value:"+ids);
		//		 print the log response in report 
//		ExtentCucumberAdapter.addTestStepLog("Print the id values"+ids);

	}
	
	@Test
	public void BgetRequest()
	{
		//		create get pre request script 
		request=RestAssured.given().log().all().header("Content-Type",ContentType.JSON);

		//			https:reqres.in/api/users?page=2
		//		pass the id in path parameter and execute get api
		response=request.get(urlss.retrievegetapi.endpoint()+ids);
		//		validate the 200 response code 
		response.then().log().all().assertThat().statusCode(200);
		//		create unknown get pre request script
}
		@Test
		public void  CpostRequest()
		{
		request=RestAssured.given().log().all().header("Content-Type",ContentType.JSON);
		//			https:reqres.in/api/unknown
		//		execute get api
		response=request.when().get(urlss.validateunknownapi.endpoint());
		//		validate the 200 response code 
		response.then().assertThat().statusCode(200);
		//		get the response data from the year 2000 color 
		List<Map<String, Object>> dataList = response.jsonPath().getList("data");
		
	
		
		// Filter the data for the year 2000
		Map<String, Object> year2000Data = dataList.stream().filter(data -> data.get("year").equals(20000)).findFirst().orElse(null);
		
		Map<String,Object> year2020Data = dataList.stream().filter(data->data.get("year".equals(2000))).findFirst().orElse(null);

		// Validate the color status for the year 2000
		if (year2000Data != null) {
			String color = (String) year2000Data.get("color");
           System.out.println("Color for the year 2000: " + color);
			Assert.assertEquals("#98B2D1", color);
	
	}
}
}