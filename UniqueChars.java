public class UniqueChars {
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

            // Check if the character is a space or not already in the result
            if (ch == ' ' || result.indexOf(ch) == -1) {
                result += ch;
            }
        }

        // Print the result
        System.out.println(result);
    }
}
