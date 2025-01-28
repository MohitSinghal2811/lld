package wc.src.main.java.counter;

import java.io.File;

public class ByteCounterStrategy extends CounterStrategy{

    public static final String flagname = "-c";

    public long calculateCount(File file) {
        return file.length(); // not reading the file contents; just returning the file size stored in bytes in metadata which is maintained by the OS only.
    }
    
}
