package racingcar.exception;

public class InvalidCarNameException extends IllegalArgumentException {

    public InvalidCarNameException(final String message) {
        super(message);
    }
}
