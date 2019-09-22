package abstract_data_types;
import java.io.IOException;
import java.util.List;

public interface Input {
    public List<String> readAll() throws IOException;
}
