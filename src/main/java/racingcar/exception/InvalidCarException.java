package racingcar.exception;

public class InvalidCarException extends IllegalArgumentException {

    public InvalidCarException(final String message) {
        super(message);
    }
}
