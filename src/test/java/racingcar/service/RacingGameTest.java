package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Route;
import racingcar.movestrategy.AlwaysMove;
import racingcar.movestrategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private MoveStrategy moveStrategy;
    private Route route;
    private List<Cars> carRoutes;

    @BeforeEach
    void setUp() {
        moveStrategy = new AlwaysMove();
        route = RacingGame.race(Arrays.asList("1", "2", "3"), 3, moveStrategy);
        carRoutes = route.getCarRoutes();
    }

    @DisplayName("RacingGame race의 결과 Route는 자동차가 지나온 distance들을 기록한다")
    @Test
    void route() {
        for (int i = 0; i < carRoutes.size(); i++) {
            final List<Car> cars = carRoutes.get(i).getCars();
            for (int j = 0; j < cars.size(); j++) {
                assertThat(cars.get(j).isSameDistance(Car.of("same", i + 1, moveStrategy))).isTrue();
            }
        }
    }
}
