package racingcar;

import racingcar.exception.InvalidCarNameException;

import java.util.Objects;

public class CarName {
    static final int CARNAME_VALIDATE_SIZE = 5;
    static final String INPUT_VALID_NAME = "1 ~ 5자 사이의 이름을 입력해주세요.";

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
}
