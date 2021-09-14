package sk.stuba.fei.uim.oop.matrix;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FPrint implements Print {
    // The name of the file to open.
    private String fileName;

    public FPrint() {
        this("out.csv");
    }

    public FPrint(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void sendMessage(String message) {
        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(message);

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
