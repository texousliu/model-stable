package cn.texous.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * <p>Title: MD5����</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2011</p>
 *
 * <p>Company: dboo</p>
 *
 * @author not attributable
 * @version 1.0
 */
public class MD5 {
  public static byte[] getKeyedDigest(byte[] buffer, byte[] key) {
    try {
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      md5.update(buffer);
      return md5.digest(key);
    }
    catch (NoSuchAlgorithmException e) {
    }
    return null;
  }

  public static String getKeyedDigest(String strSrc, String key) {
    try {
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      md5.update(strSrc.getBytes("UTF8"));
      String result = "";
      byte[] temp;

      temp = md5.digest(key.getBytes("UTF8"));
      for (int i = 0; i < temp.length; i++) {
        result += Integer.toHexString( (0x000000ff & temp[i]) |
                                      0xffffff00).substring(6);
      }
      return result;
    }
    catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String MD5(String strSrc) {
	    try {
	      MessageDigest md5 = MessageDigest.getInstance("MD5");
	      md5.update(strSrc.getBytes("UTF8"));
	      String result = "";
	      byte[] temp;

	      temp = md5.digest("".getBytes("UTF8"));
	      for (int i = 0; i < temp.length; i++) {
	        result += Integer.toHexString( (0x000000ff & temp[i]) |
	                                      0xffffff00).substring(6);
	      }
	      return result;
	    }
	    catch (NoSuchAlgorithmException e) {
	      e.printStackTrace();
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	    return null;
	  }
  
  
}
