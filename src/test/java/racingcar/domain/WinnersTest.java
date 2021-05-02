package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.movestrategy.AlwaysMove;
import racingcar.movestrategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    private final MoveStrategy moveStrategy = new AlwaysMove();

    @DisplayName("가장 멀리 간 Car가 Winner이다")
    @Test
    void winner() {
        //given
        final Cars cars = getCars("a,1", "b,2", "c,3", "d,4", "e,5");

        //when
        final List<Car> winnerCars = getWinnerCars(cars);

        //then
        assertThat(winnerCars.size()).isEqualTo(1);
        assertThat(winnerCars).contains(Car.of("e", 5, moveStrategy));
    }

    @DisplayName("Winner는 여러개 일 수 있다")
    @Test
    void coWinner() {
        //given
        final Cars cars = getCars("a,2", "b,2", "c,3", "d,4", "e,4");

        //when
        final List<Car> winnerCars = getWinnerCars(cars);

        assertThat(winnerCars.size()).isEqualTo(2);
        assertThat(winnerCars).containsExactly(
                Car.of("d", 4, moveStrategy),
                Car.of("e", 4, moveStrategy));
    }

    private Cars getCars(final String... values) {
        List<Car> cars = new ArrayList<>();
        for (final String value : values) {
            String[] split = value.split(",");
            cars.add(Car.of(split[0], Integer.parseInt(split[1]), moveStrategy));
        }
        return Cars.of(cars);
    }

    private List<Car> getWinnerCars(final Cars cars) {
        final Winners winners = Winners.getWinners(cars);
        return winners.getWinners();
    }
}
