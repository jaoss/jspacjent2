package okl.jspacjent.utility;

//--------------------------------------------------------------------

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//--------------------------------------------------------------------

/** */
public class Md5HashCode {
  // ...
	private static Log logger = LogFactory.getLog(Md5HashCode.class);
	
  /**
   * Koduje dany String do MD5 
   * @param  text     String do zakodowania
   * @return rezultat kodowania MD5
   */
  public static String getMd5HashCode(String text) {
    String passMD5 = null;
    try {
      byte[] passwordBytes    = text.getBytes();
      MessageDigest algorithm = MessageDigest.getInstance("MD5");
      algorithm.reset();
      algorithm.update(passwordBytes);
      byte[] messageDigest   = algorithm.digest();
      StringBuffer hexString = new StringBuffer();
      for ( int i = 0; i < messageDigest.length; i++ ) {
        String hex = Integer.toHexString(0xFF & messageDigest[i]);
        if ( hex.length() == 1 ) {
          hexString.append('0');
        }
        hexString.append(hex);
      }
      passMD5 = hexString + "";
    } 
    catch (NoSuchAlgorithmException ex) {
        logger.error("MD5 error: " + ex.getMessage());
    }
    return passMD5;
  }
  
}
//--------------------------------------------------------------------

