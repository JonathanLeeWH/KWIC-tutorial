package shared_memory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Consumer;

public class Main {
    
    
    /**
     * Shared data
     */
	private static String inputFileName = "implementations/in.txt";
	private static String outputFileName = "implementations/out_sm.txt";
	private static String ignoreFileName = "implementations/ignore.txt";
    private static HashSet<String> wordsToIgnore;
    private static ArrayList<ArrayList<String>> input;
    private static ArrayList<ArrayList<String>> index;
    
    public static void main(String args[]) throws IOException{
        
        initMemory();
        readInput();
        circularShift();
        alphabetize();
        output();
        
    }
    
    
    /**
     * Method to initialize the memory to empty ArrayLists
     */
    private static void initMemory(){
        wordsToIgnore = new HashSet<String>();
        input = new ArrayList<>();
        index = new ArrayList<>();
    }
    
    /**
     * Method that reads the program's input from file using user indications in console
     * @throws IOException
     */
    private static void readInput() throws IOException{
        consumeInputFile(ignoreFileName, (word) -> {
            wordsToIgnore.add(word.toLowerCase());
        });
        
        consumeInputFile(inputFileName, (title) -> {
            input.add(new ArrayList<String>(Arrays.asList( title.split(" "))));
        });
        
    }
    
    /**
     * Utility method that read a text file and apply a Consumer on each of the file's lines
     * @param fileName name of the file to read
     * @param f consumer applied on each line of the file
     * @throws IOException
     */
    private static void consumeInputFile(String fileName, Consumer<String> f) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
         while((line = reader.readLine()) != null){
             if(!line.isEmpty()){
                 f.accept(line.trim());
             }
         }
         reader.close();
    }
    
    /**
     * Methods that add to index all the titles rotations that do not begin with a word to ignore
     */
    private static void circularShift(){
        ArrayList<String> toAdd;
        for(ArrayList<String> line : input){
            toAdd = line;
            for(int i = 0; i < line.size(); ++i){
                if(!wordsToIgnore.contains(toAdd.get(0).toLowerCase())){
                    index.add(toAdd);
                }
                toAdd = shiftOnce(toAdd);
            }
        }
        
        
    }
    
    /**
     * Compute a 1 step shift of a line
     * @param toRotate the line to shift
     * @return a 1 step shift of a shallow copy of the input list
     */
    private static ArrayList<String> shiftOnce(ArrayList<String> toRotate){
        ArrayList<String> rotation = (ArrayList<String>) toRotate.clone(); //a shallow copy is sufficient to create circular shift
        rotation.add(rotation.remove(0));                     // without compromising the source list as we do not touch the content of the list (and even if we did, as String is immutable, it wouldn't change anything)
        return rotation;
    }
    
    
    /**
     * Simple method that sort the index by comparing the first string of each list (it is basicaly useless as it contains 1 line of code)
     */
    private static void alphabetize(){
        index.sort((l1,l2) -> l1.get(0).compareToIgnoreCase(l2.get(0)));
    }
    
    
    /**
     * Method that recompute string from the index lines and print them to file.
     */
    private static void output(){
        
        FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(new File(outputFileName));
			for(ArrayList<String> r : index){
	        	fileWriter.append(recomputeString(r)).append('\n');
	        }
	        fileWriter.flush(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * Utility method that compute a string by flattening a list of string, adding a whitespace between each source list's string
     * @param title
     * @return
     */
    private static String recomputeString(ArrayList<String> title){
        
        StringBuilder b = new StringBuilder();
        for(String s : title){
            b.append(s).append(' ');
        }
        
        return b.toString().trim();
    }
    
}
