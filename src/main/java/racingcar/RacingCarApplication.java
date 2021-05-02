package racingcar;

import racingcar.controller.GameController;

public class RacingCarApplication {
    public static void main(String[] args) {
        final ApplicationContext applicationContext = new ApplicationContext();
        final GameController gameController = applicationContext.getGameController();
        gameController.start();
    }
}
