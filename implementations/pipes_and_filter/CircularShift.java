package pipes_and_filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CircularShift extends Filter {
    private String noiseWords[];
    private ArrayList<String> wordList;
    CircularShift(Pipe input, Pipe output, String... noiseWords) {
        super(input,output);
        this.noiseWords = noiseWords;
    }

    @Override
    public void begin() {
        String line = read();
        while (line!=null) {
            wordList = doShift(line);
            for (String word: wordList) {
//                System.out.println("shift " + word);
                write(word);
            }
            line = read();
        }
    }
    private ArrayList<String> doShift(String line) {
        ArrayList<String> shiftedWords = new ArrayList<>();
        List<String> words = Arrays.asList(line.split("\\s+"));
        for (int i = 0; i<words.size(); i++) {
            Collections.rotate(words,-1);

            if (Arrays.stream(noiseWords).noneMatch(words.get(0)::equalsIgnoreCase)) {
                shiftedWords.add(words.toString().replace("[","").replace("]","").replace(",",""));
            }
        }
        return shiftedWords;
    }

}
