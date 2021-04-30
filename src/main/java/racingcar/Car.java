package racingcar;

import racingcar.exception.InvalidCarException;

import java.util.Objects;

public class Car {
    static final int CARNAME_VALIDATE_SIZE = 5;
    static final String INPUT_VALID_NAME = "1 ~ 5자 사이의 이름을 입력해주세요.";

    private final String name;

    public Car(final String name) {
        final String trimmedName = name.trim();
        validate(trimmedName);
        this.name = trimmedName;
    }

    private void validate(final String name) {
        if (name.isEmpty() || name.length() > CARNAME_VALIDATE_SIZE) {
            throw new InvalidCarException(INPUT_VALID_NAME);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
