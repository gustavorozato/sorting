package utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class File {
    private String fileName;

    private File(String fileName) {
        this.fileName = fileName;
    }

    public static File getFileInstance(String fileName) {
        return new File(fileName);
    }

    public Optional<String> getFileLine() {
        Optional<String> read = Optional.empty();
        try {
            Path path = Paths.get(this.fileName);
            read = Optional.of(Files.readAllLines(path).get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return read;
    }
}
