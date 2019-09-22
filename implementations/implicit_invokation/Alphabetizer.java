package implicit_invokation;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

import implicit_invokation.MyLines;

class Alphabetizer implements Observer {

    @Override
    public void update(Observable o, Object arg) { // called whenever the observed object is changed
        MyLines lines = (MyLines) o;
        MyLinesEvent event = (MyLinesEvent) arg; // Cast the argument to the MyLinesEvent, which contains the line
        Collections.sort(lines.getAllLines());
    }
}
