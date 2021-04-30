package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidCarException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("Car 이름을 6자리 이상 입력하면 InvalidCarException이 발생한다")
    @Test
    void carNameSizeOver() {
        assertThatThrownBy(() -> {
            new Car("123456");
        }).isInstanceOf(InvalidCarException.class);
    }

    @DisplayName("Car 이름을 입력하지 않으면 InvalidCarException이 발생한다")
    @Test
    void carNameEmpty() {
        assertThatThrownBy(() -> {
            new Car("");
        }).isInstanceOf(InvalidCarException.class);
    }

    @DisplayName("Car 이름을 공백으로 입력하면 InvalidCarException이 발생한다")
    @Test
    void carNameBlank() {
        assertThatThrownBy(() -> {
            new Car("   ");
        }).isInstanceOf(InvalidCarException.class);
    }

    @DisplayName("Car 이름을 1 ~ 5자리 내로 입력하면 객체가 생성된다 (공백은 제거되며 이름이 같다면 equals의 결과도 같다)")
    @ParameterizedTest
    @ValueSource(strings = {" pobi ", "crong ", "honux", "12345", "1"})
    void carOK(final String name) {
        final Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name.trim());
        assertThat(car).isEqualTo(new Car(name.trim()));
    }

}
