/**
 * 
 */
package url.shortner.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author omnitya.jha
 *
 */
public class URLShortnerDTOImpl implements URLShortnerDTO {
	
	private static Map<String, String> map = new HashMap<String, String>();

	@Override
	public void storeUrl(String shortUrl, String url) {
		map.put(shortUrl, url);
	}

	@Override
	public String retrieveURL(String shortUrl) {
		return map.get(shortUrl);
	}

	@Override
	public boolean containsShortURL(String shortUrl) {
		return map.containsKey(shortUrl);
	}

}
