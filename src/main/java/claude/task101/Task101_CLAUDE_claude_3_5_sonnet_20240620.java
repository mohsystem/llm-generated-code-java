package claude.task101;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.util.*;

public class Task101_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        String filename = "script.sh";
        String content = "#!/bin/bash \n echo \"Hello, World!\"";

        try {
            // Create the file
            FileWriter writer = new FileWriter(filename);
            writer.write(content);
            writer.close();

            // Attempt to set executable permissions (only works on UNIX)
            Path path = Paths.get(filename);
            try {
                Set<PosixFilePermission> perms = new HashSet<>();
                perms.add(PosixFilePermission.OWNER_READ);
                perms.add(PosixFilePermission.OWNER_WRITE);
                perms.add(PosixFilePermission.OWNER_EXECUTE);
                perms.add(PosixFilePermission.GROUP_READ);
                perms.add(PosixFilePermission.GROUP_EXECUTE);
                perms.add(PosixFilePermission.OTHERS_READ);
                perms.add(PosixFilePermission.OTHERS_EXECUTE);

                Files.setPosixFilePermissions(path, perms);
            } catch (UnsupportedOperationException e) {
                // On Windows: fallback
                path.toFile().setExecutable(true, false);
            }

            System.out.println("File created and (attempted) permission set.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
