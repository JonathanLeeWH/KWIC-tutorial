package implicit_invokation;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Observable class that notify observers on any new lines detected.
 * Keeps a list of the strings.
 */
class MyLines extends Observable {

    private List<String> lines = new ArrayList<String>();

    public void insert(String line) {
        lines.add(line);
        setChanged(); // Marks this Observable object as having been changed
        notifyObservers(new MyLinesEvent(line));
    }

    public List<String> getAllLines() {
        return lines;
    }
}