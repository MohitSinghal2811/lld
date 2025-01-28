package wc.src.main.java.counter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordCounterStrategy extends CounterStrategy{
	public static final String flagname = "-w";

    public long calculateCount(File file) {
		long wordCount = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                scanner.next(); 
                wordCount++;
            }
            return wordCount;
        } catch (IOException e) {
            e.printStackTrace();
			return 0;
        }
    }
}
