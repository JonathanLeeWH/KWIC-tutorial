package pipes_and_filter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Output implements Runnable{
    private Pipe inputPipe;
    private String outputFileName;
    Output(Pipe input, String output) {
    	inputPipe = input;
        outputFileName = output;
    }

    @Override
    public void run() {
        try {
        	FileWriter fileWriter = new FileWriter(new File(outputFileName));
            String line = inputPipe.read();
            while (line!=null) {
                fileWriter.append(line).append('\n');
                line = inputPipe.read();
            }
            fileWriter.flush(); 
        } catch (NoSuchElementException e) {
            //should not read when buffer empty
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }

}
