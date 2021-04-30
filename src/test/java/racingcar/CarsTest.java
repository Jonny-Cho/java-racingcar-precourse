package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarNameException;
import racingcar.movestrategy.AlwaysMove;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @DisplayName("공백이 하나라도 있으면 InvalidCarException이 발생한다")
    @Test
    void carsBlank() {
        assertThatThrownBy(() -> {
            Cars.of(" pobi ,  , honux,pobi");
        }).isInstanceOf(InvalidCarNameException.class);
    }

    @DisplayName("6글자 이상인 Car가 하나라도 있으면 InvalidCarException이 발생한다")
    @Test
    void carsSizeOver() {
        assertThatThrownBy(() -> {
            Cars.of(" pobi , crongg , honux,pobi");
        }).isInstanceOf(InvalidCarNameException.class);
    }

    @DisplayName("구분자를 사용해 Car객체들을 담는 Cars 객체를 만들 수 있다")
    @Test
    void carsOk() {
        final Cars cars = Cars.of(" pobi , crong, honux");
        assertThat(cars).isInstanceOf(Cars.class);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @DisplayName("중복된 값이 있더라도 다른 인스턴스의 Car를 생성한다")
    @Test
    void carsDuplicateOK() {
        final Cars cars = Cars.of(" pobi , crong, honux,pobi");
        assertThat(cars).isInstanceOf(Cars.class);
        assertThat(cars.getCars().size()).isEqualTo(4);
    }

    @DisplayName("moveAll메서드는 모든 Car를 move시킬 수 있다")
    @Test
    void moveAll() {
        final Cars cars = Cars.of(" pobi , crong, honux,pobi", new AlwaysMove());
        cars.moveAll();
        for (final Car car : cars.getCars()) {
            assertThat(car.getDistance()).isEqualTo(1);
        }
    }

}
