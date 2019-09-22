package implicit_invokation;
/**
 * Class that sets a string to be used by observers.
 */
class MyLinesEvent {
    private String line;

    MyLinesEvent(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}