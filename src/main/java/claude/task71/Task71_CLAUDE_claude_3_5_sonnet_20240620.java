package claude.task71;

public class Task71_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a string argument.");
            return;
        }
        
        String input = args[0];
        try {
            int result = Integer.parseInt(input);
            System.out.println("Converted integer: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Cannot convert to integer.");
        }
    }
}
