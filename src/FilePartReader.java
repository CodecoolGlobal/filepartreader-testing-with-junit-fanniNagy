import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        setup("/home/fanni/CC/OOP/SI5/FilePartReader/test.txt", 4, 6);
    }

    void setup(String filePath, int fromLine, int toLine) throws IllegalArgumentException {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.toLine = toLine;
        this.fromLine = fromLine;
    }

    String read() throws IOException {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new IOException();
        }
    }

    String readLines() throws IOException {
        StringBuilder result = new StringBuilder();
        try {
            String raw = read();
            List<String> test = Arrays.asList(raw.split("\n"));
            for (int i = fromLine - 1; i < toLine; i++) {
                result.append(test.get(i)).append(" /");
            }
            return result.toString();
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
