import java.util.Scanner;

public class AuthoringAssistant {
      
   static public void printMenu()
   {
      System.out.println();
      System.out.println("MENU");
      System.out.println("c - Number of non-whitespace characters");
      System.out.println("w - Number of words");
      System.out.println("f - Find text");
      System.out.println("r - Replace all !'s");
      System.out.println("s - Shorten spaces");
      System.out.println("q - Quit");
      System.out.println();
      System.out.println("Choose an option: ");
      
      return;
   }
      
   public static int getNumOfNonWSCharacters(String usrStr)
   {
      int i = 0;
      int j = 0;
            
      for (i = 0 ; i < usrStr.length(); ++i )
      {
            if (Character.isWhitespace(usrStr.charAt(i)) == false)
            {
               j = j + 1;
            }
            
      }
      return (j);
      
   }
   public static int getNumOfWords(String userString)
   {
      int i = 0;
      int wordCount = 0;
      
      for (i = 0 ; i < userString.length(); ++i )
      { 
            if (Character.isWhitespace(userString.charAt(i)) && Character.isWhitespace(userString.charAt(i -1)) == false)
            {
                    ++wordCount;
            }
            
      }
  
      if (Character.isWhitespace(userString.length()) == false)
      {
      ++wordCount;
      }
      return (wordCount);
      
   }
   public static int findText(String userWord, String userString)
   {
      int i = 0;
      int j = 0;
      int wordCount = 0;
      String nextSegment = userString;
      int userWordLength = userWord.length();
      int userStringLength = userString.length();
      
      while (userWordLength <= nextSegment.length() && nextSegment.indexOf(userWord) != -1)
      { //System.out.println(nextSegment.indexOf(userWord));
            if (nextSegment.indexOf(userWord) != -1)
            {//System.out.println(nextSegment);
               j = nextSegment.indexOf(userWord);
               ++wordCount;
               nextSegment = nextSegment.substring((j + userWordLength), nextSegment.length());
            }
      }
      return (wordCount);
   }
   public static String replaceExclamation(String userString)
   {
    userString = userString.replace('!','.');
    return userString;
   }
   public static String shortenSpace(String userInput)
   {
      int i = 0;
      int j = 0;
      String partialStr = "";
      
      for (i = 1 ; i < userInput.length(); ++i )
      {//System.out.println(partialStr);
            if (Character.isWhitespace(userInput.charAt(i)) && Character.isWhitespace(userInput.charAt(i - 1)))
            { //System.out.println(i);
                    partialStr = partialStr.concat(userInput.substring(j,i));
                    j = i + 1;
            }   

      }
      if (Character.isWhitespace(userInput.length()) == false)
      {
      partialStr = partialStr.concat(userInput.substring(j,i));
      userInput = partialStr;
      }
      return (userInput);
   }
   
   public static void main(String[] args) {
      Scanner assistantEditor = new Scanner(System.in);
      String userText;
      String userFindWord;
      char userCommand;
      boolean quitCommand = false;
      
      System.out.println("Enter a sample text: ");
      userText = assistantEditor.nextLine();
      System.out.println("You entered: " + userText);
      
      
      AuthoringAssistant.printMenu();
      
      userCommand = assistantEditor.next().charAt(0);
      
      while (quitCommand == false)      
      {
         if (userCommand == 'c' || userCommand ==  'w' || userCommand ==  'f' || userCommand ==  'r' || userCommand ==  's' || userCommand ==  'q' )
         {
            switch (userCommand)
            {
               case 'c':
                  System.out.println("Number of non-whitespace characters: " + AuthoringAssistant.getNumOfNonWSCharacters(userText));
                  //quitCommand = true;
                  break;
               case 'w':
                  System.out.println("Number of words: " + AuthoringAssistant.getNumOfWords(userText));
                  //quitCommand = true;
                  break;
               case 'f':
                  System.out.println("Enter a word or phrase to be found: ");
                  assistantEditor.nextLine();
                  userFindWord = assistantEditor.nextLine();
                  System.out.println("\"" + userFindWord + "\" instances: " + AuthoringAssistant.findText(userFindWord, userText));
                  //quitCommand = true;
                  break;
               case 'r':
                  System.out.println("Edited text: " + AuthoringAssistant.replaceExclamation(userText));
                  //quitCommand = true;
                  break;
               case 's':
                  System.out.println("Edited text: " + AuthoringAssistant.shortenSpace(userText));
                  //quitCommand = true;
                   break;
               case 'q':
                  quitCommand = true;
                  break;
               default :
                  System.out.print("boo");
                  break;
             }
             userCommand = 't';
         }
         else
         {
            AuthoringAssistant.printMenu();
            userCommand = assistantEditor.next().charAt(0);
         }
      }
      
       return;
   }
}