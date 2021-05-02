package racingcar.view.input;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInput implements Input, AutoCloseable {
    private final Scanner scanner;

    public ConsoleInput(final InputStream stream) {
        this.scanner = new Scanner(stream);
    }

    @Override
    public void println(final String message) {
        System.out.println(message);
    }

    @Override
    public String getCarNames() {
        return scanner.nextLine();
    }

    @Override
    public int getTryCount() {
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void close() {
        scanner.close();
    }

}
