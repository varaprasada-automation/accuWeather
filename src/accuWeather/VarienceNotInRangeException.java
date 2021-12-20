package accuWeather;

/* Custom Exception to check is variance is in valid range */

public class VarienceNotInRangeException extends Exception {
	public VarienceNotInRangeException(String errorMessage) {
		super(errorMessage);
	}
}
