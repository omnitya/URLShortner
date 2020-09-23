/**
 * 
 */
package url.shortner.service;

import url.shortner.URLExistException;
import url.shortner.dto.URLShortnerDTO;
import url.shortner.dto.URLShortnerDTOImpl;
import url.shortner.util.UrlShortnerUtil;

/**
 * @author omnitya.jha
 *
 */
public class URLShortnerService {

	URLShortnerValidator validator = new URLShortnerValidator();
	URLShortnerDTO dto = new URLShortnerDTOImpl();
	private final String DOMAIN = "https://tinyurl.com/";
	
	/**
	 * This method will create and return short URL
	 * @param url
	 * @param customLink
	 * @param expiration
	 * @return
	 */
	public String createUrl(String url, String customLink, int expiration) throws URLExistException {
		String shortUrl;
		validator.validateUrlFormat(url);
		validator.validateCustomLink(customLink);
		
		String hash = UrlShortnerUtil.generateHash(customLink, url);
		shortUrl = createShortURL(hash);
		if(dto.containsShortURL(shortUrl)) {
			throw new URLExistException("URL Already Exist!");
		}
		dto.storeUrl(shortUrl, url);
		return shortUrl;
	}
	
	private String createShortURL(String hash) {
		StringBuilder sb = new StringBuilder();
		sb.append(DOMAIN);
		sb.append(hash);
		
		return sb.toString();
	}

	public String getURL(String shortUrl) {
		if(dto.containsShortURL(shortUrl)) {
			return dto.retrieveURL(shortUrl); 
		} else {
			throw new URLExistException("No URL Found!");
		}
	}

}
