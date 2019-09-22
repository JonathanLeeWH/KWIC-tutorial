package pipes_and_filter;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Pipe {
    private Queue<String> buffer;
    private boolean emptyBuffer = false;
    private boolean closed = false;
    Pipe() {
        buffer = new LinkedList<>();
    }

    String read() throws NoSuchElementException {
        if (emptyBuffer) {
            throw new NoSuchElementException("Buffer is empty");
        }

        try {
            Object line = buffer.remove();
            return (String) line;
        } catch (NoSuchElementException e) {
            emptyBuffer = true;
        }
        return null;

    }
    void write(String input) {
        if (!closed) {
            buffer.offer(input);
        }
    }
    public void eof() {
        closed = true;
        buffer.add(null);
    }

}
