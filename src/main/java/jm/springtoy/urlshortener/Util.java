package jm.springtoy.urlshortener;

import java.security.MessageDigest;

public class Util {
    public static String encrypt(String type, String pwd) {
        try{
            MessageDigest digest = MessageDigest.getInstance(type);
            byte[] hash = digest.digest(pwd.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
