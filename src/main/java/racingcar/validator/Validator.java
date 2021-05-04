package racingcar.validator;

import racingcar.exception.InvalidCarNameException;
import racingcar.exception.InvalidValueException;

import java.util.List;
import java.util.Objects;

import static racingcar.domain.CarName.CARNAME_VALIDATE_SIZE;
import static racingcar.exception.InvalidValueException.WRONG_VALUE;
import static racingcar.view.input.InputMessages.INPUT_VALID_NAME;

public class Validator {

    public static void validateCarName(final String name) {
        final String trimmedName = name.trim();
        if (Objects.isNull(trimmedName) || trimmedName.isEmpty() || trimmedName.length() > CARNAME_VALIDATE_SIZE) {
            throw new InvalidCarNameException(INPUT_VALID_NAME);
        }
    }

    public static void validateCarName(final List<String> carNames) {
        validateEmptyList(carNames);
        validateElements(carNames);
    }

    private static void validateEmptyList(final List<String> carNames) {
        if (Objects.isNull(carNames) || carNames.isEmpty()) {
            throw new InvalidValueException(WRONG_VALUE);
        }
    }

    private static void validateElements(final List<String> carNames) {
        for (final String carName : carNames) {
            validateCarName(carName);
        }
    }

}
