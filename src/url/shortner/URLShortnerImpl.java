/**
 * 
 */
package url.shortner;

import url.shortner.service.URLShortnerService;

/**
 * @author omnitya.jha
 *
 */
public class URLShortnerImpl implements URLShortner {
	
	URLShortnerService service = new URLShortnerService();

	@Override
	public String createURLShortner(String url, String customLink, int expiration) {
		return service.createUrl(url, customLink, expiration);
	}

	@Override
	public String getUrl(String shortUrl) {
		return service.getURL(shortUrl);
	}

}
