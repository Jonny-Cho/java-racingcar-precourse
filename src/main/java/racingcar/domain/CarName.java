package racingcar.domain;

import racingcar.validator.Validator;

import java.util.Objects;

public class CarName {
    public static final int CARNAME_VALIDATE_SIZE = 5;

    private final String name;

    public CarName(final String name) {
        final String trimmedName = name.trim();
        Validator.validateCarName(trimmedName);
        this.name = trimmedName;
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
