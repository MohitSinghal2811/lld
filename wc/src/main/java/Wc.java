package wc.src.main.java;

import java.io.File;
import java.util.Arrays;
import java.util.Vector;

import wc.src.main.java.counter.ByteCounterStrategy;
import wc.src.main.java.counter.CharacterCounterStrategy;
import wc.src.main.java.counter.Constants;
import wc.src.main.java.counter.LineCounterStrategy;
import wc.src.main.java.counter.WordCounterStrategy;

public class Wc {
    public static void main(String[] args) {
        handleInput(args);
    }

    private static void handleInput(String[] args) {
        if(args.length < 1) {
            System.out.println("Incorrect arguments");
            return;
        }

        Vector<String> flags = new Vector<>();
        Vector<String> files = new Vector<>();

        for(String arg: args){
            if(Arrays.asList(Constants.ALLOWED_FLAGS).contains(arg)){
                flags.add(arg);
            }
            else {
                files.add(arg);
            }
        }

        if(flags.size() == 0){
            flags.addAll(Arrays.asList(Constants.DEFAULT_FLAGS));
        }

        String fileName = args[1];
        String flag = args[0];


        File file = readFile(fileName);

        if (file == null) {
            return;
        }

        switch (flag) {
            case ByteCounterStrategy.flagname:
                printCount(ByteCounterStrategy.calculateCount(file), fileName);
                break;
            case LineCounterStrategy.flagname:
                printCount(LineCounterStrategy.calculateCount(file), fileName);
                break;
            case WordCounterStrategy.flagname:
                printCount(WordCounterStrategy.calculateCount(file), fileName);
                break;
            case CharacterCounterStrategy.flagname:
                printCount(CharacterCounterStrategy.calculateCount(file), fileName);
                break;
        
            default:
                break;
        }
        
    }

    private static void printCount(long count, String fileName){
        System.out.println(count + " " + fileName);
    }

    private static File readFile( String fileName){
        File file = null;

        try {
            file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File does not exist: " + fileName);
                return null;
            }
        } catch (SecurityException e) {
            System.out.println("Security exception: Unable to access the file.");
            e.printStackTrace();
            return null;
        } catch (NullPointerException e) {
            System.out.println("File name is null.");
            e.printStackTrace();
            return null;
        }

        return file;
    }
}
