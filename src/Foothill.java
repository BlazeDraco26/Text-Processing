// Lab #5
// Jordan Cheng

import java.util.Scanner;

public class Foothill
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
   
   // main method
   public static void main(String[] args)
   {
      int keyCharCount = 0;
      char keyChar;
      String userString;
      String maskString;
      String removeString;
      inputStream = new Scanner(System.in);
      
      keyChar = getKeyCharacter();
      userString = getString();
      maskString = maskCharacter(userString, keyChar);
      removeString = removeCharacter(userString, keyChar);
      keyCharCount = keyCount(userString, keyChar);

      System.out.println("String with '" + keyChar + "' masked:" + SEPARATOR + 
            maskString + SEPARATOR);
      System.out.println("String with '" + keyChar + "' removed:" + SEPARATOR + 
            removeString + SEPARATOR);
      System.out.println("# " + keyChar + "s: " + keyCharCount);

      
      inputStream.close(); 

   }
   
}

/* ---------------------------- run #1 -------------------------------------

Please enter a SINGLE character to act as key:
a
Please enter a phrase or sentence >= 6 and <= 500 characters:
Apples are amazing for your health. After all, they keep the doctor away.
String with 'a' masked:
 Apples $re $m$zing for your he$lth. After $ll, they keep the doctor $w$y.

String with 'a' removed:
 Apples re mzing for your helth. After ll, they keep the doctor wy.

# as: 7

-------------------------------------------------------------------------- */

/* ---------------------------- run #2 -------------------------------------

Please enter a SINGLE character to act as key:
21
Please enter a SINGLE character to act as key:
fjdaskl;j dasl;fjsn;hba;lfad
Please enter a SINGLE character to act as key:
a SINGLE character to act as a key:
Please enter a SINGLE character to act as key:
okay fine
Please enter a SINGLE character to act as key:
y
Please enter a phrase or sentence >= 6 and <= 500 characters:
12
Please enter a phrase or sentence >= 6 and <= 500 characters:
no
Please enter a phrase or sentence >= 6 and <= 500 characters:
(((
Please enter a phrase or sentence >= 6 and <= 500 characters:
Why are yams so tasty?
String with 'y' masked:
 Wh$ are $ams so tast$?

String with 'y' removed:
 Wh are ams so tast?

# ys: 3

-------------------------------------------------------------------------- */

/* ---------------------------- run #3 -------------------------------------

Please enter a SINGLE character to act as key:
a SINGLE character to act as key:
Please enter a SINGLE character to act as key:
!
Please enter a phrase or sentence >= 6 and <= 500 characters:
BRO I SWEAR THE WAY COLLEGEBOARD DOES THINGS SOMETIMES ARE JUST PURE EVIL!!!!!!!!!!!
String with '!' masked:
 BRO I SWEAR THE WAY COLLEGEBOARD DOES THINGS SOMETIMES ARE JUST PURE EVIL$$$$$$$$$$$

String with '!' removed:
 BRO I SWEAR THE WAY COLLEGEBOARD DOES THINGS SOMETIMES ARE JUST PURE EVIL

# !s: 11


-------------------------------------------------------------------------- */

/* ---------------------------- run #4 -------------------------------------

Please enter a SINGLE character to act as key:
 
Please enter a phrase or sentence >= 6 and <= 500 characters:
Jack and Jill went up the hill.
String with ' ' masked:
 Jack$and$Jill$went$up$the$hill.

String with ' ' removed:
 JackandJillwentupthehill.

#  s: 6

-------------------------------------------------------------------------- */

/* ---------------------------- run #5 -------------------------------------

Please enter a SINGLE character to act as key:
5
Please enter a phrase or sentence >= 6 and <= 500 characters:
5 times. 5 &*%^ing times it took for me to pass my provisional license exam!!!! Is this a joke???? IS MY LIFE JUST A SERIES OF 1, 2, 3, 4, 5 ATTEMPTS AT EVERYTHING???
String with '5' masked:
 $ times. $ &*%^ing times it took for me to pass my provisional license exam!!!! Is this a joke???? IS MY LIFE JUST A SERIES OF 1, 2, 3, 4, $ ATTEMPTS AT EVERYTHING???

String with '5' removed:
  times.  &*%^ing times it took for me to pass my provisional license exam!!!! Is this a joke???? IS MY LIFE JUST A SERIES OF 1, 2, 3, 4,  ATTEMPTS AT EVERYTHING???

# 5s: 3

-------------------------------------------------------------------------- */
