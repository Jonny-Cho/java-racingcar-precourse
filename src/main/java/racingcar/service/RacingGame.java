package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.Route;
import racingcar.movestrategy.MoveStrategy;

import java.util.List;

import static racingcar.controller.GameController.ZERO;

public class RacingGame {
    public static Route race(final List<String> carNames, final int tryCount, final MoveStrategy moveStrategy) {
        final Route route = new Route();
        final Cars cars = Cars.of(carNames, moveStrategy);
        for (int i = ZERO; i < tryCount; i++) {
            cars.moveAll();
            route.record(cars, moveStrategy);
        }
        return route;
    }
}
