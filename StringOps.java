public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {

        String vow = "yellow";
        System.out.println(capVowelsLowRest(vow));
        String inputString = "MMMM";
        char targetChar = 'M';

        int[] result = allIndexOf(inputString, targetChar);

        System.out.println("Indexes of '" + targetChar + "' in '" + inputString + "':");
        for (int index : result) {
            System.out.print(index + " ");
        }
    }

    /*The function returns a string in which all the English vowels (a,e,i,o,u) in the original strings
     are changed to uppercase, and all the other characters are changed to lowercase */

    public static String capVowelsLowRest (String string) {

        char[] vowels = {'a', 'i', 'o', 'u', 'e'};
        int ln = string.length();
        String result = "";

        
        for (int i = 0; i < ln ; i++ ) {

            Boolean upper = isUpper(string.charAt(i));
            Boolean vowel = false;

            for (int j = 0; j < 5 ; j++ ) {
            
                if(string.charAt(i) == vowels[j] || string.charAt(i) == vowels[j] - 32) {

                    vowel = true;

                    if (!upper)
                        result += (char)(string.charAt(i) - 32);
                    else
                        result += string.charAt(i);

                }

             }

         if (isUpper(string.charAt(i)) && !vowel)
            {

                result += (char)(string.charAt(i) + 32);
            }

                else if (!vowel && !upper)
                    result += string.charAt(i);

            }
    

            return result;
    }
   /* 
    The function returns a string in which the original string is modified according to three rules:
    1. The first word is changed to lowercase (if it’s not lowercase already).
    2. The first letter of each word is changed to uppercase (if it’s not uppercase already), and all the remaining letters in the word are changed to lowercase (if they are not lowercase already).
    3. All the spaces (if any) are removed.
*/
    public static String camelCase (String string) {
        
        String result = "";

       if (string.charAt(0) >= 65 && string.charAt(0) <= 90) {

            result += (char)(string.charAt(0) + 32);
            
        }
        else
            result += string.charAt(0);

        for (int i = 1; i < string.length() ; i++ ) {

            if(string.charAt(i) == ' ')
            {
                while (i + 1 < string.length() && string.charAt(i + 1) == ' ') {
                     i++; 
                 }
             }

            if (i + 1 < string.length()  && string.charAt(i) == ' ') {

                 result += Character.toUpperCase(string.charAt(i + 1));
                 i++; 
            }
            else
                {
                     if (isUpper(string.charAt(i))) 
                    result += (char)(string.charAt(i) + 32);
               
                     else
                        result += string.charAt(i);

                }            
           
                
        }

        return result;
    }

//Returns an array containing all the indexes in which the character appears in the string.
    public static int[] allIndexOf (String string, char chr) {

        int size = 0;

        for (int i = 0; i < string.length() ; i++ ) {

            if (string.charAt(i) == chr) {

                size++;
            }
        }

        int[] result = new int[size];

        int index = 0;

        for (int j = 0; j < string.length() ;j++ ) {

            if(string.charAt(j) == chr)

                result[index++] = j;

            
        }

        return result;
    }

    /* Returns true if a given char is upper case and false otherwise */

    public static boolean isUpper (char chr) {

         if (chr >= 65 && chr <= 90)
            return true;

        else
            return false;
    }


}
