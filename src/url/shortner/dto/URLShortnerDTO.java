/**
 * 
 */
package url.shortner.dto;

/**
 * @author omnitya.jha
 *
 */
public interface URLShortnerDTO {
	
	public void storeUrl(String url, String shortUrl);
	
	public String retrieveURL(String shortUrl);
	
	public boolean containsShortURL(String shortUrl);

}
