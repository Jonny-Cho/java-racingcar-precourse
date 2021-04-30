package racingcar;

import racingcar.movestrategy.MoveStrategy;
import racingcar.movestrategy.RandomlyMove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    static final String DELIMITER = ",";

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    static Cars of(final String carNames) {
        return of(carNames, new RandomlyMove());
    }

    static Cars of(final String carNames, final MoveStrategy moveStrategy) {
        return of(moveStrategy, carNames.split(DELIMITER));
    }

    static Cars of(final MoveStrategy moveStrategy, final String... carNames) {
        return of(Arrays.asList(carNames), moveStrategy);
    }

    static Cars of(final List<String> carNames, final MoveStrategy moveStrategy) {
        final List<Car> cars = toCars(carNames, moveStrategy);
        return new Cars(cars);
    }

    private static List<Car> toCars(final List<String> carNames, final MoveStrategy moveStrategy) {
        final List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.of(name, moveStrategy));
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll() {
        for (final Car car : cars) {
            car.move();
        }
    }
}
