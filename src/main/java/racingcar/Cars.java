package racingcar;

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
        return of(carNames.split(DELIMITER));
    }

    static Cars of(final String... carNames) {
        return of(Arrays.asList(carNames));
    }

    static Cars of(final List<String> carNames) {
        final List<Car> cars = toCars(carNames);
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    private static List<Car> toCars(final List<String> carNames) {
        final List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
