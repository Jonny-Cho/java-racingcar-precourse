package racingcar.exception;

public class InvalidCarNameException extends IllegalArgumentException {

    public static String WRONG_VALUE = "잘못된 입력값입니다.";

    public InvalidCarNameException(final String message) {
        super(message);
    }
}
