package racingcar.view.input;

import racingcar.exception.InvalidValueException;
import racingcar.validator.Validator;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static racingcar.domain.Cars.DELIMITER;
import static racingcar.view.input.InputMessages.*;

public class ConsoleInput implements Input, AutoCloseable {
    private final Scanner scanner;

    public ConsoleInput(final InputStream stream) {
        this.scanner = new Scanner(stream);
    }

    @Override
    public List<String> getCarNames() {
        println(PLEASE_INPUT_CAR_NAMES);
        try {
            final List<String> carNames = toList(inputCarNames().split(DELIMITER));
            Validator.validateCarName(carNames);
            return carNames;
        } catch (final InvalidValueException e) {
            return getCarNames();
        }
    }

    @Override
    public int getTryCount() {
        println(PLEASE_INPUT_TRY_COUNT);
        try {
            return inputTryCount();
        } catch (final NumberFormatException e) {
            println(PLEASE_INPUT_NUMBER);
            return getTryCount();
        }
    }

    @Override
    public void close() {
        scanner.close();
    }

    private void println(final String message) {
        System.out.println(message);
    }

    private int inputTryCount() {
        return Integer.parseInt(scanner.nextLine());
    }

    private List<String> toList(final String[] strings) {
        return Arrays.asList(strings);
    }

    private String inputCarNames() {
        return scanner.nextLine();
    }

}
