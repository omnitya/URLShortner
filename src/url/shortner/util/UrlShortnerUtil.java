/**
 * 
 */
package url.shortner.util;

import java.util.Base64;

/**
 * @author omnitya.jha
 *
 */
public class UrlShortnerUtil {
	
	public static String generateHash(String customLink, String url) {
		String uniqueURL;
		if(customLink != null) {
			uniqueURL = customLink;
		} else {
			uniqueURL = Base64Hash(url);
		}
		return uniqueURL;
	}
	
	private static String Base64Hash(String url) {
		String encodedURL = Base64.getUrlEncoder() 
                .encodeToString(url.getBytes());
		return encodedURL.substring(0, 7);
	}

}
