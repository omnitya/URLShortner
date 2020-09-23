/**
 * 
 */
package url.shortner.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author omnitya.jha
 *
 */
public class URLShortnerValidator {
	
	private final String EXPRESSION = "^[-a-zA-Z0-9._]+";
	
	public boolean validateUrlFormat(String url) {
		try {
			URL testUrl = new URL(url);
		} catch (MalformedURLException e) {
			return false;
		}
		return true;
	}
	
	public boolean validateCustomLink(String customLink) {
		if(customLink != null) {
			Pattern pattern = Pattern.compile(EXPRESSION);
			Matcher matcher = pattern.matcher(customLink);
			return matcher.matches();
		}
		return true;
	}

}
