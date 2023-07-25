package testing.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtil {

    public static String readFileAsString(String filename) throws IOException {
        Resource resource = new ClassPathResource(filename);
        Path path = resource.getFile().toPath();
        return Files.readString(path);
    }
}
