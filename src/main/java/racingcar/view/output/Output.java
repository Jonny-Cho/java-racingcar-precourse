package racingcar.view.output;

import racingcar.domain.Cars;
import racingcar.domain.Winners;

public interface Output {

    void print(final String message);

    void println(final String message);

    void printRacingResult(final Cars cars);

    void printWinners(final Winners winners);

}
