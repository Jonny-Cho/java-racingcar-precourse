package racingcar.view.output;

import racingcar.domain.Route;
import racingcar.domain.Winners;

public interface Output {

    void printWinners(final Winners winners);

    void printRoute(final Route carRoute);
}
