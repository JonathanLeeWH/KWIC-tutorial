package abstract_data_types;
import java.util.List;

public class MyLines implements LineStorage {

    private List<String> lines;

    public MyLines (List<String> lines) {
        this.lines = lines;
    }

    @Override
    public List<String> getLines() {
        return lines;
    }

}
