package abstract_data_types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyShift implements CircularShift {
    private List<String> lines;

    public MyShift(List<String> lines) {
        this.lines = circularShift(lines);
    }

    private List<String> circularShift(List<String> lines) {
        List<String> result = new LinkedList<String>();

        for (String line: lines) {
            List<String> words = new ArrayList<String>();
            words.addAll(Arrays.asList(line.split(" ")));

            for (int i = 0; i < words.size(); i++) {
                // remove the first word and add to end of the line
                words.add(words.size() -1, words.remove(0));
                result.add(arrayToString(words));
            }
        }
        return result;
    }

    private String arrayToString(List<String> array) {
        StringBuilder sb = new StringBuilder();

        for (String word: array) {
            sb.append(word);
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    @Override
    public List<String> getShiftedLines() {
        return lines;
    }
}
