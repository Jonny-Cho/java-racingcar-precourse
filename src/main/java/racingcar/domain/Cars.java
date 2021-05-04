package racingcar.domain;

import racingcar.movestrategy.MoveStrategy;
import racingcar.movestrategy.RandomlyMove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    public static final String DELIMITER = ",";

    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Cars(final List<Car> cars, final MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public static Cars of(final String carNames) {
        return of(carNames, new RandomlyMove());
    }

    public static Cars of(final String carNames, final MoveStrategy moveStrategy) {
        return of(moveStrategy, carNames.split(DELIMITER));
    }

    public static Cars of(final MoveStrategy moveStrategy, final String... carNames) {
        return of(Arrays.asList(carNames), moveStrategy);
    }

    public static Cars of(final List<String> carNames, final MoveStrategy moveStrategy) {
        final List<Car> cars = toCars(carNames, moveStrategy);
        return new Cars(cars, moveStrategy);
    }

    private static List<Car> toCars(final List<String> carNames, final MoveStrategy moveStrategy) {
        final List<Car> cars = new ArrayList<>();
        for (final String name : carNames) {
            cars.add(Car.of(name, moveStrategy));
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> cloneCars() {
        final List<Car> newCars = new ArrayList<>();
        for (final Car car : cars) {
            newCars.add(car.cloneCar());
        }
        return newCars;
    }

    public void moveAll() {
        for (final Car car : cars) {
            car.move();
        }
    }

    public List<Car> sortedBy() {
        final List<Car> newCars = new ArrayList(this.cars);
        newCars.sort(Car::compareTo);
        return newCars;
    }

    @Override
    public String toString() {
        return "cars" + cars;
    }

}
