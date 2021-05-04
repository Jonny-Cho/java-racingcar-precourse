package racingcar.controller;

import racingcar.domain.Route;
import racingcar.domain.Winners;
import racingcar.movestrategy.MoveStrategy;
import racingcar.service.RacingGame;
import racingcar.view.input.Input;
import racingcar.view.output.Output;

import java.util.List;

public class GameController {
    public static final int ZERO = 0;

    private final Input input;
    private final Output output;
    private final MoveStrategy moveStrategy;

    public GameController(final Input input, final Output output, final MoveStrategy moveStrategy) {
        this.input = input;
        this.output = output;
        this.moveStrategy = moveStrategy;
    }

    public void start() {
        final List<String> carNames = input.getCarNames();
        final int tryCount = input.getTryCount();
        final Route carRoute = RacingGame.race(carNames, tryCount, moveStrategy);
        final Winners winners = Winners.getWinners(carRoute);
        output.printRoute(carRoute);
        output.printWinners(winners);
    }

}
