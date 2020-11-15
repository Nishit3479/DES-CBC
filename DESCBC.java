package cryptography;

import java.util.*;

public class DESCBC
{  
 
 public static void main(String[] argv) throws Exception
 {
	 Scanner in = new Scanner(System.in);
	 System.out.println("Enter Message : ");
	 String st = in.nextLine();
	 System.out.println("Choose Option :\n1.Encryption\n2.Decryption");
	 int a =in.nextInt();
	 if(a==1)
	 {
		 Encrypt e = new Encrypt();
		 byte[] str=e.doEncryption(st);
		 String s = new String(str);
		 System.out.println("Encrypted String : "+s);
	 }
	 else if(a==2)
	 {
		 Decrypt d = new Decrypt();
		 byte[] bytes = st.getBytes();
		 System.out.println("Decrypted String : "+d.doDecryption(bytes));
	 }
	 else
	 {
		 System.out.println("Invalid Choice");
	 }
 }
}
