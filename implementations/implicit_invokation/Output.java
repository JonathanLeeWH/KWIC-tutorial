package implicit_invokation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import implicit_invokation.MyLines;

class Output {
    void writeFile(MyLines lines, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (String line : lines.getAllLines()) {
            fileWriter.append(line).append('\n');
        }
        fileWriter.flush();
    }
}