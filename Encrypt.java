package cryptography;

import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

class Encrypt
{
 public KeyGenerator keygenerator;
 public SecretKey key;
 Cipher c;
 public IvParameterSpec iv;
 public Encrypt() throws Exception
 { 
  keygenerator = KeyGenerator.getInstance("DES");
  keygenerator.init(new SecureRandom());
  key = keygenerator.generateKey();
  
  String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
  System.out.println("Key : "+encodedKey);

  c = Cipher.getInstance("DES/CBC/PKCS5Padding");
  
  String st = "76812435";
  
  iv = new IvParameterSpec(st.getBytes());
 }
 public byte[] doEncryption(String s) throws Exception
 {
     
      c.init(Cipher.ENCRYPT_MODE, key,iv);

      
      byte[] text = s.getBytes();

  
      byte[] textEncrypted = c.doFinal(text);

   return(textEncrypted);
 }
 public String doDecryption(byte[] s)throws Exception
 {
 
      c.init(Cipher.DECRYPT_MODE, key,iv);

     
      byte[] textDecrypted = c.doFinal(s);

   return(new String(textDecrypted));
 }
}