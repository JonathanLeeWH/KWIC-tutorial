package implicit_invokation;
import java.util.*;

import implicit_invokation.MyLines;

class CircularShift implements Observer {
    private MyLines shifts;

    public CircularShift(MyLines shifts) {
        this.shifts = shifts;
    }

    @Override
    public void update(Observable o, Object arg) { // called whenever the observed object is changed
        MyLines lines = (MyLines) o;
        MyLinesEvent event = (MyLinesEvent) arg; // Cast the argument to the MyLinesEvent, which contains the line

        List<String> result = new LinkedList<String>();
        List<String> words = new ArrayList<String>(Arrays.asList(event.getLine().split(" ")));
        for (int i = 0; i < words.size(); i++) {
            // remove the first word and add to end of the line
            words.add(words.size() -1, words.remove(0));
            result.add(arrayToString(words));
        }

        for (String shift : result) {
            shifts.insert(shift); // shifts now contains all the new circularly shifted lines
        }
    }

    private String arrayToString(List<String> arr) {
        StringBuilder sb = new StringBuilder();
        for (String word : arr) {
            sb.append(word);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}