// Lab #5
// Jordan Cheng

import java.util.Scanner;

public class Foothill2
{
   // define constants
   private static final int STRING_LENGTH_LOWER = 6;
   private static final int STRING_LENGTH_UPPER = 500;
   private static final int CHARACTER_LENGTH = 1;
   private static final char DOLLAR_SIGN = '$';
   private static final String SEPARATOR = "\n"; 
   private static Scanner inputStream;
   
   // obtain user sentence
   public static String getString()
   {
      String userSentence = null;
      int numChars = 0;
             
      while ((numChars < STRING_LENGTH_LOWER) || (numChars > STRING_LENGTH_UPPER))
      {
         
         System.out.println("Please enter a phrase or sentence >= " + 
               STRING_LENGTH_LOWER + " and <= " + STRING_LENGTH_UPPER + " characters:");
         userSentence = inputStream.nextLine();
                 
         numChars = userSentence.length();
            
      }
     
      return(userSentence);
   }
   
   // obtain key character
   public static char getKeyCharacter()
   {
      String keyCharacter = null;
      int charLength = 0;
      
      while (charLength != CHARACTER_LENGTH) 
      {
         
         System.out.println("Please enter a SINGLE character to act as key:");
         keyCharacter = inputStream.nextLine();
         
         charLength = keyCharacter.length();
         
      }
      
      return(keyCharacter.charAt(0));
   }
   
   // return string with $ in place of key character
   public static String maskCharacter(String theString, char keyCharacter)
   {
      char keyChar = DOLLAR_SIGN;
      String maskString = " ";
      int i;
      
      for (i = 0; i < theString.length(); i++) 
      {
         if (theString.charAt(i) == keyCharacter) {
            maskString = maskString + keyChar;
         } else {
            maskString = maskString + theString.charAt(i);

         }
      
      }
      return maskString;

   }
   
   // return string omitting key characters
   public static String removeCharacter(String theString, char keyCharacter)
   {
      String newString = " ";
      int i;
      
      for (i = 0; i < theString.length(); i++) {
         
         if (theString.charAt(i) != keyCharacter) {
            
            newString = newString + theString.charAt(i);

         }
         
      
      }
      return newString;

   }
   
   // count # of key characters in string
   public static int keyCount(String theString, char keyCharacter)
   {

      int keyCount = 0;
      int i;
      
      for (i = 0; i < theString.length(); i++) 
      {
         if (theString.charAt(i) == keyCharacter) {
            
            keyCount = keyCount + 1;
 
         }
             
      }
      return keyCount;
   
   }
   
   public static void printResults(int keyCharCount, char keyChar, String userString, String maskString, String removeString)
   {
      

      System.out.println("String with '" + keyChar + "' masked:" + SEPARATOR + 
            maskString + SEPARATOR);
      System.out.println("String with '" + keyChar + "' removed:" + SEPARATOR + 
            removeString + SEPARATOR);
      System.out.println("# " + keyChar + "s: " + keyCharCount);
   }
   
   public static int sum(int x, int y) {
      int sum;
      sum = x + y;
      return sum;
   }

   public static int sum2(int x, int y) {
      return x + y;
   }
   
   public static int square(int x) {
      return x ^ 2;
   }
   
   public static int square2(int x) {
      return x * x;
   }

   // main method
   public static void main(String[] args)
   {
      inputStream = new Scanner(System.in);
      int keyCharCount = 0;
      int totalValue;
      int totalValue2;
      int x = 0;
      int y = 0;
      int a = 0;
      int b = 0;
      char keyChar;
      String userString;
      String maskString;
      String removeString;
      
      keyChar = getKeyCharacter();
      userString = getString();
      maskString = maskCharacter(userString, keyChar);
      removeString = removeCharacter(userString, keyChar);
      keyCharCount = keyCount(userString, keyChar);
      printResults(keyCharCount, keyChar, removeString, removeString, removeString); 
      totalValue = sum(x, y);
      System.out.println("x + y equals:" + totalValue);
      totalValue = sum(a, b);
      System.out.println("x + y equals:" + totalValue);
      totalValue2 = square(x);

      
      totalValue = sum(10, 2);
      System.out.println("x + y equals:" + totalValue);
      
      inputStream.close(); 

   }
   
}


