package cstjean.prog4.exercice6;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements LoggerBase {
    public int mask;
    FileWriter writer;
    public FileLogger(int mask) throws IOException {
        this.mask = mask;
        writer = new FileWriter("textfile.txt");
    }
    @Override
    public void log(String message) {
        try {
            writer.write(message);
            writer.close();
        } catch (IOException ex) {
            System.out.println("Erreur dans l'écriture du fichier");
        }
    }
    @Override
    public String getBinaryMask() {
        return Integer.toBinaryString(mask);
    }
}
