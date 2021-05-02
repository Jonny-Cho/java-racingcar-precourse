package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.movestrategy.AlwaysMove;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("여러가지 방법으로 Car객체를 생성할 수 있다")
    @Test
    void carCreateOK() {
        final Car car1 = Car.of("car1");
        final Car car2 = Car.of("car2", 0);
        final Car car3 = Car.of("car3", new AlwaysMove());
        final Car car4 = Car.of("car3", 1, new AlwaysMove());
        assertThat(car1).isNotNull();
        assertThat(car2).isNotNull();
        assertThat(car3).isNotNull();
        assertThat(car4).isNotNull();
    }

    @DisplayName("move를 하면 moveStrategy에 따라 Distance가 1씩 증가할 수 있다")
    @Test
    void carMove() {
        final Car car = Car.of("car1", new AlwaysMove());
        for (int i = 1; i <= 10; i++) {
            car.move();
            assertThat(car.getDistance()).isEqualTo(i);
        }
    }

}
