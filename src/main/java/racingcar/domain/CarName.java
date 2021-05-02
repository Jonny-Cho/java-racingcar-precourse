package racingcar.domain;

import racingcar.exception.InvalidCarNameException;

import java.util.Objects;

import static racingcar.ApplicationContext.CARNAME_VALIDATE_SIZE;
import static racingcar.view.input.InputMessages.INPUT_VALID_NAME;

public class CarName {

    private final String name;

    public CarName(final String name) {
        final String trimmedName = name.trim();
        validate(trimmedName);
        this.name = trimmedName;
    }

    private void validate(final String name) {
        if (name.isEmpty() || name.length() > CARNAME_VALIDATE_SIZE) {
            throw new InvalidCarNameException(INPUT_VALID_NAME);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
