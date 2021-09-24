package stepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;



public class StepsGermany {
	ResponseSpecification respec;
	Response response;
	JsonPath jsonPathObject;
	String responseString;
	int count;
	

	@Given("User navigates to API")
	public void user_navigates_to_api() {
		RestAssured.baseURI = "http://api.citybik.es/v2/networks";
		respec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}

	@When("User request Get http request")
	public void user_request_get_http_request() {
		response = given().when().get().then().assertThat().spec(respec).extract().response();
		responseString = response.asString();
		jsonPathObject = new JsonPath(responseString);
	}

	@Then("User should be able to find the all the networks' details")
	public void user_should_be_able_to_find_the_all_the_networks_details() {
		count=jsonPathObject.getInt("networks.size()");
		System.out.println("Printing the size of the array (networks)");
		System.out.println(count);
		
	}
	@Then("User should be able to find CityBikes all the networks' details")
	public void user_should_be_able_to_find_city_bikes_all_the_networks_details() {
		System.out.println(responseString);
		
	}
		

@Then("Response code should be {int}")
public void response_code_should_be(Integer int1) {
	int expectedCode=response.getStatusCode();
	assertEquals(expectedCode,200);
	
}

@Then("User should be able to find the Franfurt's country and Its latitude and longitude which should be {string}")
public void user_should_be_able_to_find_the_franfurt_s_country_and_its_latitude_and_longitude_which_should_be(String string) {
	for(int j=0;j<count;j++)
	{
		HashMap<String,String> location=jsonPathObject.get("networks["+j+"].location");
	
		String city=jsonPathObject.get("networks["+j+"].location.city");
		String country=jsonPathObject.get("networks["+j+"].location.country");
		//System.out.println(bikeName);
		if(city.equalsIgnoreCase("Frankfurt")&& country.equalsIgnoreCase("DE"))
		{
			System.out.println("Longitude of Germany is:" +jsonPathObject.get("networks["+j+"].location.longitude"));
			System.out.println("Latitude of Germany is:" +jsonPathObject.get("networks["+j+"].location.latitude"));
			break;
			
		}
}
}

@Then("User should be able to find the location of City bikes")
public void user_should_be_able_to_find_the_location_of_city_bikes() {
	for(int i=0;i<count;i++)
	{
		String bikeName=jsonPathObject.get("networks["+i+"].name");
		if(bikeName.equalsIgnoreCase("City bikes"))
		{
			System.out.println("\n");
			HashMap<String,String> location=jsonPathObject.get("networks["+i+"].location");
			System.out.println("Printing the location of City bikes");
			System.out.println(location);
			break;
			
		}
    
}


}

	
	
}
	




