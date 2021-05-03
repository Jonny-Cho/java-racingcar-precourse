package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.exception.InvalidCarNameException;
import racingcar.movestrategy.MoveStrategy;
import racingcar.view.input.Input;
import racingcar.view.output.Output;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        final int tryCount = getTryCount();
        race(cars, tryCount);
        final Winners winners = Winners.getWinners(cars);
        output.printWinners(winners);
    }

    private Cars getCars() {
        final List<String> carNames = inputCarNames();
        try {
            return Cars.of(carNames, moveStrategy);
        } catch (final InvalidCarNameException e) {
            input.println(e.getMessage());
            return getCars();
        }
    }

    private List<String> inputCarNames() {
        input.println(PLEASE_INPUT_CAR_NAMES);
        try {
            final List<String> carNames = toList(input.getCarNames().split(DELIMITER));
            validateCarName(carNames);
            return carNames;
        } catch (final InvalidCarNameException e) {
            return inputCarNames();
        }
    }

    private void validateCarName(final List<String> carNames) {
        validateEmptyList(carNames);
        validateEmptyElement(carNames);
    }

    private void validateEmptyElement(final List<String> carNames) {
        for (final String carName : carNames) {
            validateBlank(carName);
        }
    }

    private void validateBlank(final String carName) {
        final String trimmedName = carName.trim();
        if (Objects.isNull(trimmedName) || trimmedName.isEmpty()) {
            throw new InvalidCarNameException("입력값 중에 하나라도 빈 값이 될 수는 없습니다.");
        }
    }

    private void validateEmptyList(final List<String> carNames) {
        if (Objects.isNull(carNames) || carNames.isEmpty()) {
            throw new InvalidCarNameException("잘못된 입력값입니다.");
        }
    }

    private List<String> toList(final String[] strings) {
        return Arrays.asList(strings);
    }

    private int getTryCount() {
        input.println(PLEASE_INPUT_TRY_COUNT);
        try {
            return input.getTryCount();
        } catch (final NumberFormatException e) {
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
