package abstract_data_types;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class FileOutput implements Output {

    private OutputStreamWriter output;

    public FileOutput (String fileName) throws FileNotFoundException {
        output = new OutputStreamWriter(new FileOutputStream(new File(fileName)));
    }

    @Override
    public void writeLines(List<String> lines) throws IOException {
        for (String line : lines) {
            // writes each line with a line space
            output.write(line);
            output.write("\n");
        }
    }

    @Override
    public void close() throws IOException {
        output.close();
    }
}
