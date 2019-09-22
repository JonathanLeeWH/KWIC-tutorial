package implicit_invokation;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        MyLines lines = new MyLines();
        MyLines shifts = new MyLines();
        Input input = new Input();
        Output output = new Output();

        // For performing circular shifting after detecting a new line
        lines.addObserver(new CircularShift(shifts));

        // For alphabetical sorting after detecting detecting circular shifts
        shifts.addObserver(new Alphabetizer());

        try {	
            input.readFile(lines, new File("implementations/in.txt"));
            output.writeFile(shifts, new File("implementations/out_ii.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}