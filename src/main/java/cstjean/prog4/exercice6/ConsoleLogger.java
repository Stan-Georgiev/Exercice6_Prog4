package cstjean.prog4.exercice6;

public class ConsoleLogger implements LoggerBase {
    public int mask;

    public ConsoleLogger(int mask) {
        this.mask = mask;
    }
    @Override
    public void log(String message) {
        System.out.println(message);
    }
    @Override
    public String getBinaryMask() {
        return Integer.toBinaryString(mask);
    }
}
