package wc.src.main.java.counter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterCounterStrategy extends CounterStrategy {
    public static final String flagname = "-m";

    public long calculateCount(File file) {

        long characterCount = 0;

        try (FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader reader = new BufferedReader(isr)) {

            while ((reader.read()) != -1) {
                characterCount++;
            }
            return characterCount;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

    }
}
