package gtp4o.task100;

import java.util.regex.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task100_OPENAI_gpt_4o {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Task100_OPENAI_gpt_4o <pattern> <filename>");
            return;
        }
        String patternString = args[0];
        String filename = args[1];

        try {
            String content = new String(Files.readAllBytes(Paths.get(filename)));
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}