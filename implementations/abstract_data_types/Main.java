package abstract_data_types;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // read an input file
        Input input = new FileInput("implementations/in.txt");
        // add all the lines of words into the storage
        LineStorage lines = new MyLines(input.readAll());
        // circular shift to move the alphabets
        CircularShift shift = new MyShift(lines.getLines());
        // sort all the alphabets
        Alphabetizer alphabetizer = new MyAlphabetizer(shift.getShiftedLines());
        // create output and write the lines into a file called out.txt
        Output output = new FileOutput("implementations/out_adt.txt");
        output.writeLines(alphabetizer.getLines());
        output.close();

    }
}
