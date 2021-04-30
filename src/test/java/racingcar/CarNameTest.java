package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidCarNameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @DisplayName("CarName을 6자리 이상 입력하면 InvalidCarNameException이 발생한다")
    @Test
    void carNameSizeOver() {
        assertThatThrownBy(() -> {
            new CarName("123456");
        }).isInstanceOf(InvalidCarNameException.class);
    }

    @DisplayName("CarName을 입력하지 않으면 InvalidCarNameException이 발생한다")
    @Test
    void carNameEmpty() {
        assertThatThrownBy(() -> {
            new CarName("");
        }).isInstanceOf(InvalidCarNameException.class);
    }

    @DisplayName("CarName을 공백으로 입력하면 InvalidCarNameException이 발생한다")
    @Test
    void carNameBlank() {
        assertThatThrownBy(() -> {
            new CarName("   ");
        }).isInstanceOf(InvalidCarNameException.class);
    }

    @DisplayName("CarName을 1 ~ 5자리 내로 입력하면 객체가 생성된다 (공백은 제거되며 이름이 같다면 equals의 결과도 같다)")
    @ParameterizedTest
    @ValueSource(strings = {" pobi ", "crong ", "honux", "12345", "1"})
    void carOK(final String name) {
        final CarName carName = new CarName(name);
        assertThat(carName.getName()).isEqualTo(name.trim());
        assertThat(carName).isEqualTo(new CarName(name.trim()));
    }

}
