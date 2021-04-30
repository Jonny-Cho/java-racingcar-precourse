package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @DisplayName("공백이 하나라도 있으면 Exception이 발생한다")
    @Test
    void carsBlank() {
        assertThatThrownBy(() -> {
            Cars.of(" pobi ,  , honux,pobi");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6글자 이상인 Car가 하나라도 있으면 Exception이 발생한다")
    @Test
    void carsSizeOver() {
        assertThatThrownBy(() -> {
            Cars.of(" pobi ,  , honux,pobi");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("콤마 구분자를 사용해 Car객체들을 담는 Cars 객체를 만들 수 있다")
    @Test
    void carsOk() {
        final Cars cars = Cars.of(" pobi , crong, honux");
        assertThat(cars.getCars()).containsExactly(new Car("pobi"), new Car("crong"), new Car("honux"));
    }

    @DisplayName("중복된 값이 있더라도 다른 인스턴스의 Car를 생성한다")
    @Test
    void carsDuplicateOK() {
        final Cars cars = Cars.of(" pobi , crong, honux,pobi");
        assertThat(cars.getCars()).containsExactly(new Car(" pobi"), new Car("crong"), new Car("honux"), new Car("pobi"));
    }

}
