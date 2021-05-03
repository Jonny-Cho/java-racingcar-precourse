package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.exception.InvalidCarNameException;
import racingcar.exception.InvalidValueException;
import racingcar.movestrategy.MoveStrategy;
import racingcar.validator.Validator;
import racingcar.view.input.Input;
import racingcar.view.output.Output;

import java.util.Arrays;
import java.util.List;

import static racingcar.domain.Cars.DELIMITER;
import static racingcar.view.input.InputMessages.*;
import static racingcar.view.output.OutputMessages.RESULT_MESSAGE;

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
        final Cars cars = getCars();
//        final List<String> carNames = input.getCarNames();
        final int tryCount = input.getTryCount();

        race(cars, tryCount);
        final Winners winners = Winners.getWinners(cars);
        output.printWinners(winners);
    }

    private Cars getCars() {
        final List<String> carNames = input.getCarNames();
        try {
            return Cars.of(carNames, moveStrategy);
        } catch (final InvalidCarNameException e) {
            input.println(e.getMessage());
            return getCars();
        }
    }

    private void race(final Cars cars, final int count) {
        output.println(RESULT_MESSAGE);
        for (int i = ZERO; i < count; i++) {
            cars.moveAll();
            output.printRacingResult(cars);
        }
    }

}
