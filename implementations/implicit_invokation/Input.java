package implicit_invokation;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import implicit_invokation.MyLines;

class Input {
    void readFile(MyLines lines, File file) throws IOException {
        for (String line : Files.readAllLines(Paths.get(file.getPath()))) {
            lines.insert(line);
        }
    }
}