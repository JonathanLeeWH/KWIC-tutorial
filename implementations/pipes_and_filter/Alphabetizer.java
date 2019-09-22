package pipes_and_filter;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer extends Filter {
    private ArrayList<String> totalInput = new ArrayList<String>();
    Alphabetizer(Pipe input, Pipe output) {
        super(input,output);
    }

    @Override
    public void begin() {
        String line = read();
        while (line!=null) {
            totalInput.add(line);
            line = read();
        }
        Collections.sort(totalInput);
        for (String word : totalInput) {
            write(word);
        }
    }
}
