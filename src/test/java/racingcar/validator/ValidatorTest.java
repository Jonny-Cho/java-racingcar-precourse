package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("empty, blank, 6자 이상의 값을 입력하면 InvalidCarNameException이 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "123456"})
    void strings(final String value) {
        assertThatThrownBy(() -> {
            Validator.validateCarName(value);
        }).isInstanceOf(Exception.class);
    }

    @DisplayName("empty, blank, 6자 이상이 아닌 값을 입력하면 아무일도 일어나지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"ok", "ok2", "12345"})
    void stringsOK(final String value) {
        Validator.validateCarName(value);
    }

    @DisplayName("empty, blank, 6자 이상의 값이 하나라도 있다면 InvalidValueException이 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {",ok,ok2", "ok, ,ok2", "ok,ok2,123456"})
    void stringList(final String values) {
        final List<String> strings = toList(values);
        assertThatThrownBy(() -> {
            Validator.validateCarName(strings);
        }).isInstanceOf(Exception.class);
    }

    @DisplayName("empty, blank, 6자 이상의 값이 하나도 없다면 아무일도 일어나지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"ok,ok2,12345", "ok,ok2,ok3", "o,12345,ok3"})
    void stringListOK(final String values) {
        final List<String> strings = toList(values);
        Validator.validateCarName(strings);
    }

    private List<String> toList(final String values) {
        return Arrays.asList(values.split(","));
    }

}
