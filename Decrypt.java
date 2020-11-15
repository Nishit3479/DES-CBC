package cryptography;

import java.util.*;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class Decrypt
{
 public KeyGenerator keygenerator;
 public SecretKey key;
 Cipher c;
 public IvParameterSpec iv;
 public Decrypt() throws Exception
 { 
	  Scanner in = new Scanner(System.in);
	  System.out.print("Enter Key (12 Characters) : ");
	  String str1 = in.next();
	  byte[] decodedKey = Base64.getDecoder().decode(str1);
	  key = new SecretKeySpec(decodedKey,0, decodedKey.length, "DES");

  c = Cipher.getInstance("DES/CBC/PKCS5Padding");
  
  String st = "76812435";
  
  iv = new IvParameterSpec(st.getBytes());
 }
 public String doDecryption(byte[] s)throws Exception
 {
 
      c.init(Cipher.DECRYPT_MODE, key,iv);

      byte[] textDecrypted = c.doFinal(s);

   return(new String(textDecrypted));
 }
}