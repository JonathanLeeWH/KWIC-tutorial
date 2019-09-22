package pipes_and_filter;


abstract public class Filter implements Runnable{
    private Pipe inputPipe;
    private Pipe outputPipe;

    Filter(Pipe input, Pipe output) {
        this.inputPipe = input;
        this.outputPipe = output;
    }

    String read() {
        return inputPipe.read();
    }
    void write(String line) {
        outputPipe.write(line);
    }
    abstract public void begin() throws InterruptedException;

    @Override
    public void run() {
        while (true) {
            try {
                begin();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
