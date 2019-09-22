package abstract_data_types;
import java.util.Collections;
import java.util.List;	

public class MyAlphabetizer implements Alphabetizer {

    private List<String> lines;

    public MyAlphabetizer (List<String> lines) {
        this.lines = sortAll(lines);
    }

    private List<String> sortAll(List<String> lines) {
        Collections.sort(lines);
        return lines;
    }

    @Override
    public List<String> getLines() {
        return lines;
    }
}
