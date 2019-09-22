package pipes_and_filter;

import java.io.*;

public class Input implements Runnable{
    private String input;
    private Pipe outputPipe;
    Input(String filePath, Pipe pipeOut) {
        this.outputPipe = pipeOut;
        this.input = filePath;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                outputPipe.write(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        outputPipe.write(null);
    }
}
