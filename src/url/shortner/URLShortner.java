/**
 * 
 */
package url.shortner;

/**
 * @author omnitya.jha
 *
 */
public interface URLShortner {
	
	public String createURLShortner(String url, String customLink, int expiration);
	
	public String getUrl(String shortUrl);

}
