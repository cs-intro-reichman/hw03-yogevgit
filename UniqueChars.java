/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String modifiedString = "" + s.charAt(0);

        for (int i = 1 ;i < s.length() ;i++ ) {

            if ((modifiedString.indexOf(s.charAt(i)) == -1) || s.charAt(i) == ' ' ) {
                modifiedString += s.charAt(i);
                
            }
            
        }


        return modifiedString;
    }
}
