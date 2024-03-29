package Chapter08;

import javax.xml.bind.*; // for DatatypeConverter

public class ReturnDigestUserInterface {
  
  public static void main(String[] args) {
    for (String filename : args) {
      // Calculate the digest
      ReturnDigest dr = new ReturnDigest(filename);
      dr.start();
      
      // Now print the result
      StringBuilder result = new StringBuilder(filename);
      result.append(": ");
      byte[] digest = dr.getDigest();
//    result.append(DatatypeConverter.printHexBinary(digest));
      result.append(digest);
      System.out.println(result); 
    }
  }
}
