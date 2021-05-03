package racingcar.exception;

public class InvalidValueException extends IllegalArgumentException {

    public static String WRONG_VALUE = "잘못된 입력값입니다.";

    public InvalidValueException(final String message) {
        super(message);
    }
}
