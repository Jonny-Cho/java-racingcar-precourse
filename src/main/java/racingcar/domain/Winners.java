package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private static final int FIRST = 0;
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public static Winners getWinners(Cars cars) {
        final List<Car> sortedCars = cars.sortedBy();
        final Car maxCar = findFirst(sortedCars);
        final List<Car> filteredCars = filter(sortedCars, maxCar);
        return new Winners(filteredCars);
    }

    private static List<Car> filter(final List<Car> sortedCars, final Car maxCar) {
        List<Car> filteredCars = new ArrayList<>();
        for (final Car car : sortedCars) {
            addToFilteredCars(filteredCars, car, maxCar);
        }
        return filteredCars;
    }

    private static void addToFilteredCars(final List<Car> filteredCars, final Car car, final Car maxCar) {
        if (car.getDistance() == maxCar.getDistance()) filteredCars.add(car);
    }

    private static Car findFirst(final List<Car> cars) {
        return cars.get(FIRST);
    }

    @Override
    public String toString() {
        return "winners=" + winners;
    }
}
