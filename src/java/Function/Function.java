/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Function;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author VuNguyen
 */
public class Function {
    public static String md5(String input) {
         
        String md5 = null;
         
        if(null == input) return null;
         
        try {
             
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
         
        //Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
 
        //Converts message digest value in base 16 (hex)
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
 
           
        }
        return md5;
    }
      public static String convertToUTF8(String s) {
        String out = "";
        try {
            out = new String(s.getBytes("iso-8859-1"), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            return "";
        }
        return "";
    } 
}
