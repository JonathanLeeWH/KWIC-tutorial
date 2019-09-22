package pipes_and_filter;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();

        Input input = new Input("implementations/in.txt", pipe1);
        String[] noiseWords = {"or", "in", "the", "to", "of", "on", "a", "an", "at", "and", "i", "it", "by", "for"};
        String[] noise = args.length == 0 ? noiseWords : args;
        Filter circularShift = new CircularShift(pipe1, pipe2, noise);
        Filter alphabetizer = new Alphabetizer(pipe2,pipe3);
        Output output = new Output(pipe3, "implementations/out_pf.txt");
        try {
            input.run();
            circularShift.begin();
            alphabetizer.begin();
            output.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
