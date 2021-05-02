package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.movestrategy.MoveStrategy;
import racingcar.view.input.Input;
import racingcar.view.output.Output;

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
        final int tryCount = getTryCount();
        race(cars, tryCount);
        final Winners winners = Winners.getWinners(cars);
        output.printWinners(winners);
    }

    private Cars getCars() {
        final String carNames = inputCarNames();
        try {
            return Cars.of(carNames, moveStrategy);
        } catch (final Exception e) {
            input.println(e.getMessage());
            return getCars();
        }
    }

    private String inputCarNames() {
        input.println(PLEASE_INPUT_CAR_NAMES);
        try {
            return input.getCarNames();
        } catch (final Exception e) {
            input.println(e.getMessage());
            return inputCarNames();
        }
    }

    private int getTryCount() {
        input.println(PLEASE_INPUT_TRY_COUNT);
        try {
            return input.getTryCount();
        } catch (final Exception e) {
            input.println(PLEASE_INPUT_NUMBER);
            return getTryCount();
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
