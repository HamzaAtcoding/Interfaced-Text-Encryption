package pkg;

import java.security.*;

public class SHA512 {
    public String getSHAhash(String str) throws NoSuchAlgorithmException{
        MessageDigest md;
        String message = str;
  
            md= MessageDigest.getInstance("SHA-512");

            md.update(message.getBytes());
            byte[] mb = md.digest();
            String out = "";
            for (int i = 0; i < mb.length; i++) {
                byte temp = mb[i];
                String s = Integer.toHexString(new Byte(temp));
                while (s.length() < 2) {
                    s = "0" + s;
                }
                s = s.substring(s.length() - 2);
                out += s;
            }
            //System.out.println(out.length());
            //System.out.println("CRYPTO: " + out);
            return out;
    }
}