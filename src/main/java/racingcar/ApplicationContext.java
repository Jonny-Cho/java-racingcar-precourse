package racingcar;

import racingcar.controller.GameController;
import racingcar.movestrategy.MoveStrategy;
import racingcar.movestrategy.RandomlyMove;
import racingcar.view.input.ConsoleInput;
import racingcar.view.input.Input;
import racingcar.view.output.ConsoleOutput;
import racingcar.view.output.Output;

public class ApplicationContext {
    public static final int CARNAME_VALIDATE_SIZE = 5;

    private final Input input;
    private final Output output;
    private final MoveStrategy moveStrategy;

    public ApplicationContext() {
        this.input = new ConsoleInput(System.in);
        this.output = new ConsoleOutput();
        this.moveStrategy = new RandomlyMove();
    }

    public GameController getGameController() {
        return new GameController(input, output, moveStrategy);
    }
}
