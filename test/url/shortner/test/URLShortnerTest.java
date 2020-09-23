/**
 * 
 */
package url.shortner.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import url.shortner.URLShortner;
import url.shortner.URLShortnerImpl;

/**
 * @author omnitya.jha
 *
 */
class URLShortnerTest {

	URLShortner urlShortner = new URLShortnerImpl();
	String url = "https://medium.com/javarevisited/25-software-design-interview-questions-to-crack-any-programming-and-technical-interviews-4b8237942db0";
	String customLink = "omjha";
	String tinyURL = "https://tinyurl.com/omjha";
	int expiration = 10;
	
	@Test
	void test_createURLShortner_WithCustomLink() {
		String shortURL = urlShortner.createURLShortner(url, customLink, expiration);
		assertEquals(shortURL, tinyURL);
		assertTrue(shortURL.contains(customLink));
	}
	
	@Test
	void test_createURLShortner_WithoutCustomLink() {
		String shortURL = urlShortner.createURLShortner(url, null, expiration);
		System.out.println(shortURL);
		assertNotEquals(shortURL, tinyURL);
		assertFalse(shortURL.contains(customLink));
	}
	
	
	void test_getUrl() {
		String Longurl = urlShortner.getUrl(tinyURL);
		assertEquals(Longurl, url);
		assertFalse(Longurl.contains(customLink));
	}
}
