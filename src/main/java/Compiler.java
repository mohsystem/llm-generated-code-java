import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Compiler {

    private static final Map<String, Integer> summary = new HashMap<>();


    public static void main(String[] args) {
        // Set the source and output directories
        String sourceDirectory = "generatedCode/llama3"; // Update this path
        String outputDirectory = "out"; // Update this path

        try {
            compileJavaFiles(sourceDirectory, outputDirectory);
            printSummary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void compileJavaFiles(String sourceDir, String outputDir) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            System.err.println("No Java compiler found. Make sure you are running with a JDK, not a JRE.");
            return;
        }

        // Get the list of Java files in the source directory and its subdirectories
        List<File> javaFiles = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get(sourceDir))) {
            javaFiles = paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        }

        if (javaFiles.isEmpty()) {
            System.out.println("No Java files found in the specified directory.");
            return;
        }

        // Prepare the compiler options
        List<String> options = new ArrayList<>();
        options.add("-d");
        options.add(outputDir);

        // Compile each Java file and classify errors
        for (File javaFile : javaFiles) {
            System.out.println("Compiling: " + javaFile.getPath());

            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(javaFile);

            // Create necessary output directories
//            Path relativePath = Paths.get(sourceDir).relativize(javaFile.toPath().getParent());
            Path outputPath = Paths.get(outputDir);
            Files.createDirectories(outputPath);

            List<String> fileOptions = new ArrayList<>(options);
            fileOptions.add("-d");
            fileOptions.add(outputPath.toString());

            JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics,
                    fileOptions, null, compilationUnits);
            boolean success = task.call();

            if (success) {
                System.out.println("Compilation successful: " + javaFile.getPath());
                summary.put(javaFile.getName(), 0); // 0 means valid
            } else {
                System.out.println("Compilation failed: " + javaFile.getPath());
                classifyErrors(diagnostics, javaFile.getName());
            }

            fileManager.close();
        }
    }

    private static void classifyErrors(DiagnosticCollector<JavaFileObject> diagnostics, String fileName) {
        boolean hasSyntaxError = false;
        boolean hasCompilationError = false;

        for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
            String errorType = classifyError(diagnostic);
            System.out.println("Error on line " + diagnostic.getLineNumber() + ": " + diagnostic.getMessage(null));
            System.out.println("Error Type: " + errorType);

            if ("Syntax Error".equals(errorType)) {
                hasSyntaxError = true;
            } else if ("Compilation Error".equals(errorType)) {
                hasCompilationError = true;
            }
        }

        if (hasSyntaxError) {
            summary.put(fileName, 1); // 1 means syntax error
        } else if (hasCompilationError) {
            summary.put(fileName, 2); // 2 means compilation error
        } else {
            summary.put(fileName, 3); // 3 means other error
        }
    }

    private static String classifyError(Diagnostic<? extends JavaFileObject> diagnostic) {
        if (diagnostic.getKind() == Diagnostic.Kind.ERROR) {
            // Simple heuristic to differentiate between syntax and other compilation errors
            String message = diagnostic.getMessage(null).toLowerCase();
            if (message.contains("';' expected") || message.contains("class, interface, or enum expected")) {
                return "Syntax Error";
            } else {
                return "Compilation Error";
            }
        }
        return "Other";
    }

    private static void printSummary() {
        int validCount = 0;
        int syntaxErrorCount = 0;
        int compilationErrorCount = 0;
        int otherErrorCount = 0;

        for (Map.Entry<String, Integer> entry : summary.entrySet()) {
            switch (entry.getValue()) {
                case 0:
                    validCount++;
                    break;
                case 1:
                    syntaxErrorCount++;
                    break;
                case 2:
                    compilationErrorCount++;
                    break;
                case 3:
                    otherErrorCount++;
                    break;
            }
        }

        System.out.println("\nSummary:");
        System.out.println("Valid files: " + validCount);
        System.out.println("Files with syntax errors: " + syntaxErrorCount);
        System.out.println("Files with compilation errors: " + compilationErrorCount);
        System.out.println("Files with other errors: " + otherErrorCount);
    }
}
