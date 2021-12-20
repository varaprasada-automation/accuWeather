package accuWeather;

import org.testng.Assert;
import org.testng.annotations.Test;
import accuWeather.*;

public class comparatorLogic {
	accuWeatherAPI api = new accuWeatherAPI();
	accuWeatherWeb web = new accuWeatherWeb();

	/* Comparator Logic */
	@Test
	public void validateApiAndWeb() throws Exception {
		String apiResult = api.getTemparature("Bangalore", "7fe67bf08c80ded756e598d6f8fedaea");
		String webResult = web.getTemparature("Bangalore");
		System.out.println("API Temparature : " + apiResult);
		System.out.println("Web Temparature : " + webResult);

		validateVariance(apiResult, webResult);
		Assert.assertEquals(apiResult, webResult);
	}

	/* Variance Logic */
	public void validateVariance(String apiResult, String webResult) throws VarienceNotInRangeException {
		float api = Float.parseFloat(apiResult);
		float web = Float.parseFloat(webResult.substring(0, webResult.length() - 3));
		float variance = 0;
		float validRange = 1.0f;

		if (api > web) {
			variance = api - web;
		} else {
			variance = web - api;
		}

		if (variance <= validRange) {
			System.out.println("Difference between API Temparature And Web Temparature is with in valid range...");
		} else {
			throw new VarienceNotInRangeException(
					"Difference between API Temparature And Web Temparature is not with in valid range...");
		}
	}
}