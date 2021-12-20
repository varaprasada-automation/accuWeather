package accuWeather;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class accuWeatherAPI {
	// @Test(dataProvider = "CityAndKey")
	// public void getTemparature(String city, String key) {
	
	@Test
	public String getTemparature(String city, String key) {
		RestAssured.baseURI = "https://api.openweathermap.org";
		String response = given().log().all().contentType(ContentType.JSON).param("q", city).param("appid", key).when()
				.get("/data/2.5/weather").then().extract().response().asString();
		JsonPath accuWeatherResponse = new JsonPath(response);
		String temparature = accuWeatherResponse.getString("main.temp");
		return temparature;
	}

	/*
	 * @DataProvider(name = "CityAndKey") public Object[][] getData() { return
	 * new Object[][] {{"Bangalore", "7fe67bf08c80ded756e598d6f8fedaea"}}; }
	 */
}