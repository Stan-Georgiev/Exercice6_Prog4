package cstjean.prog4.exercice6;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements LoggerBase {
    public int mask;
    FileWriter writer;
    public FileLogger(int mask) {
        this.mask = mask;
        try {
            writer = new FileWriter("textfile.txt", true);
        } catch (IOException e) {
            throw new RuntimeException("Erreur avec le fichier", e);
        }
    }
    @Override
    public void log(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Erreur dans l'écriture du fichier");
        }
    }

    @Override
    public String getBinaryMask() {
        return Integer.toBinaryString(mask);
    }

    public int getMask() {
        return mask;
    }
}
