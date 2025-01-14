package onerme.utilities;

import java.util.Scanner;

public class DefaultInputProvider implements InputProvider {
    private final Scanner scanner;

    public DefaultInputProvider() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
