package de.jonas_thelemann.dadasong;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class for input/output operations.
 */
public class IoUtil {

    /**
     * Creates and writes to a file.
     *
     * @param input    The text to write into the file.
     * @param fileName The file's name.
     * @throws IOException In case the write fails.
     */
    static void createFile(String input, String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        fw.write(input);
        fw.close();
    }
}
