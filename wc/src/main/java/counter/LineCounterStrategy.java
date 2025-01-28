package wc.src.main.java.counter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LineCounterStrategy extends CounterStrategy{
	public static final String flagname = "-l";

    public long calculateCount(File file) {
		long lineCount = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();  // Read the line
                lineCount++;  // Increment line count
            }
            return lineCount;
        } catch (IOException e) {
            e.printStackTrace();
			return 0;
        }
    }
}
