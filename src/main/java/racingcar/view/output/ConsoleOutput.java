package racingcar.view.output;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

import java.util.ArrayList;
import java.util.List;

import static racingcar.view.output.OutputMessages.WINNER_MESSAGE;

public class ConsoleOutput implements Output {

    public static final String NAME_DISTANCE_DELIMITER = " : ";
    public static final String WINNERS_DELIMITER = ", ";

    @Override
    public void print(final String message) {
        System.out.print(message);
    }

    @Override
    public void println(final String message) {
        System.out.println(message);
    }

    @Override
    public void printRacingResult(final Cars cars) {
        final List<Car> result = cars.getCars();
        for (final Car car : result) {
            System.out.println(car.getName() + NAME_DISTANCE_DELIMITER + printDistance(car.getDistance()));
        }
        System.out.println();
    }

    private String printDistance(final int distance) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

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
}
