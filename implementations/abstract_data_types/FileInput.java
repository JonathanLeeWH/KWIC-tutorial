package abstract_data_types;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileInput implements Input {

    private String fileName;

    public FileInput (String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> readAll() throws IOException{
        return Files.readAllLines(Paths.get(fileName));
    }
}
