package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.movestrategy.AlwaysMove;
import racingcar.movestrategy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RouteTest {
    final Cars cars = Cars.of("1, 2, 3", new AlwaysMove());
    private final MoveStrategy moveStrategy = new AlwaysMove();
    private final Route route = new Route();

    @DisplayName("기본 생성자로 Route를 생성할 수 있다")
    @Test
    void create() {
        assertThat(route).isInstanceOf(Route.class);
    }

    @DisplayName("Cars객체를 Route에 record할 수 있다")
    @Test
    void record() {
        route.record(cars, moveStrategy);
        assertThat(route.getCarRoutes().size()).isEqualTo(1);
    }

    @DisplayName("record는 Cars의 복사본을 저장한다")
    @Test
    void recordClone() {
        route.record(cars, moveStrategy);
        Cars clonedCars = route.getCarRoutes().get(0);
        assertThat(cars).isNotSameAs(clonedCars);
    }

    @DisplayName("record한 Cars객체들을 가져올 수 있다")
    @Test
    void getCars() {
        route.record(cars, moveStrategy);
        final List<Cars> carRoutes = route.getCarRoutes();
        for (final Cars carRoute : carRoutes) {
            assertThat(carRoute).isInstanceOf(Cars.class);
        }
    }

}
