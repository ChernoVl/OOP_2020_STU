package sk.stuba.fei.uim.oop.matrix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FReader implements Reader {
    // The name of the file to open.
    private String fileName;
    // This will reference one line at a time
    private String line;
    private String text;

    public FReader() {
        this("matrix.csv");
    }

    public FReader(String fileName) {
        this.fileName = fileName;
        this.line = null;
        this.text = null;
    }

    @Override
    public String getMessage() {
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            text = new String();

            while((line = bufferedReader.readLine()) != null) {
                text += line;
                text += '\n';
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return text;
    }
}
