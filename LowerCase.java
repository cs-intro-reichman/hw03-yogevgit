public class LowerCase {
    public static void main(String[] args) {
        // Check if a command-line argument is provided
        if (args.length < 1) {
            System.out.println("Please provide a string as a command-line argument.");
            return;
        }

        // The input string is the first command-line argument
        String input = args[0];
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Check if the character is an uppercase letter
            if (ch >= 'A' && ch <= 'Z') {
                // Convert to lowercase
                ch = (char) (ch + 'a' - 'A');
            }

            // Append the character to the result
            result += ch;
        }

        // Print the result
        System.out.println(result);
    }
}
        
