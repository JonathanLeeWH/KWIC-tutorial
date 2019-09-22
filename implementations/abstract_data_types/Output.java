package abstract_data_types;
import java.io.IOException;
import java.util.List;

public interface Output {
    public void writeLines(List<String> lines) throws IOException;
    public void close() throws IOException;
}
