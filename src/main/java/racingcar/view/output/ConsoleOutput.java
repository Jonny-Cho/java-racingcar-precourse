package racingcar.view.output;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Route;
import racingcar.domain.Winners;

import java.util.ArrayList;
import java.util.List;

import static racingcar.view.output.OutputMessages.RESULT_MESSAGE;
import static racingcar.view.output.OutputMessages.WINNER_MESSAGE;

public class ConsoleOutput implements Output {

    public static final String NAME_DISTANCE_DELIMITER = " : ";
    public static final String WINNERS_DELIMITER = ", ";
    public static final String DISTANCE_PRINT_SIGN = "-";

    @Override
    public void printWinners(final Winners winners) {
        final List<String> winnerCarNames = getWinnerCarNames(winners);
        System.out.println(String.join(WINNERS_DELIMITER, winnerCarNames) + WINNER_MESSAGE);
    }

    private List<String> getWinnerCarNames(final Winners winners) {
        final List<String> carNames = new ArrayList<>();
        final List<Car> winnerCars = winners.getWinners();
        for (final Car winner : winnerCars) {
            carNames.add(winner.getName());
        }
        return carNames;
    }

    @Override
    public void printRoute(final Route carRoute) {
        System.out.println(RESULT_MESSAGE);
        final List<Cars> carRoutes = carRoute.getCarRoutes();
        for (final Cars route : carRoutes) {
            printCars(route);
        }
    }

    private void printCars(final Cars route) {
        final List<Car> cars = route.getCars();
        for (final Car car : cars) {
            System.out.println(car.getName() + NAME_DISTANCE_DELIMITER + printDistance(car.getDistance()));
        }
        System.out.println();
    }

    private String printDistance(final int distance) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append(DISTANCE_PRINT_SIGN);
        }
        return sb.toString();
    }
}
