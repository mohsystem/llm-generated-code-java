package gemini.task121;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SpringBootApplication
@Controller
public class Task121_GEMINI_gemini_1_5_pro_001 {

    public static void main(String[] args) {
        SpringApplication.run(Task121_GEMINI_gemini_1_5_pro_001.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "upload"; // Assuming you have an 'upload.html' template
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/"; 
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(getUploadDirectory().getAbsolutePath() + File.separator + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Upload failed! " + e.getMessage());
            return "redirect:/";
        }

        return "redirect:/";
    }

    // Helper method to get upload directory (customize as needed)
    private File getUploadDirectory() {
        File uploadDir = new File("uploads");
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        return uploadDir;
    }
}