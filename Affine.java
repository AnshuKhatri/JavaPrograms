import java.math.BigInteger;
import java.util.Scanner;

class Affine
{
private static int firstKey = 5;
private static int secondKey = 16;
private static int module = 26;

static String encrypt(String input) {
    StringBuilder builder = new StringBuilder();
   
   // input=input.replaceAll(" ", "");
    for (int in = 0; in < input.length(); in++) {
        char character = input.charAt(in);
        if (Character.isLowerCase(character)) {
        	character = (char)((firstKey*(character - 'a') + secondKey) % 26 + 'a');
        }
    //    builder.append(character);
    
    if (Character.isUpperCase(character)) {
    	character = (char)((firstKey*(character - 'A') + secondKey) % 26 + 'A');
    }
    builder.append(character);
}
    return builder.toString();
}

static String decrypt(String input) {
    StringBuilder builder = new StringBuilder();
   
    BigInteger inverse = BigInteger.valueOf(firstKey).modInverse(BigInteger.valueOf(module));
   // System.out.println("inverse of first is" +inverse);
    for (int in = 0; in < input.length(); in++) {
        char character = input.charAt(in);
        
        if (Character.isLowerCase(character)) {
        	int decoded = inverse.intValue() * (character - 'a' - secondKey + module);
            character = (char) (decoded % module + 'a');
        }
       
       
       // builder.append(character);
    
    if (Character.isUpperCase(character)) {
    	int decoded = inverse.intValue() * (character - 'A' - secondKey + module);
        character = (char) (decoded % module + 'A');
    }
   
    builder.append(character);
}
    return builder.toString();
}


public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	String input="all is well";
	
	//System.out.println("Enter the message");
	//String input=sc.nextLine();
	 
	
	
	System.out.println(input);
	 
	 
	//for(int i=0;i<input.length;i++) 
	input=input.replaceAll(" ", "");
    

	
	String cipher = encrypt(input);
    String deciphered = decrypt(cipher);
    System.out.println("Source:    " + input);
    System.out.println("Encrypted: " + cipher);
    System.out.println("Decrypted: " + deciphered);
}




}