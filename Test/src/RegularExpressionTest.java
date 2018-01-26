import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {

		// regex for email id.
		// pramodraturi141@gmail.com, pr.raturi99@ymail.com,
		// organization name should not exceed 50 characters. must not include numerics
		// domain name should not exceed 3 characters.

		String regexPattern = "\\b[a-zA-Z0-9]+[@]+[a-zA-Z^0-9]{1,50}[.]{1}[a-zA-Z^0-9]{3}\\b";
		Pattern pattern = Pattern.compile(regexPattern); //

		Matcher matcher = pattern.matcher("pramod123@gmail.com");
		if (matcher.find()) {
			System.out.println("Valid Email ID.");
		} else {
			System.err.println("Invalid Email ID.");
		}
	}
}
