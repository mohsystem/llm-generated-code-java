package gtp4o.task70;

import java.nio.file.*;
import java.nio.charset.*;
import java.io.*;
import java.util.*;

public class Task70_OPENAI_gpt_4o {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task70_OPENAI_gpt_4o <file path>");
            return;
        }

        String filePath = args[0];
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}