package racingcar.movestrategy;

import java.util.Random;

public class RandomlyMove implements MoveStrategy {
    static final int MOVABLE_STANDARD_NUMBER = 4;
    static final int MINUS_VALUE = 1;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 10;

    @Override
    public boolean canMove() {
        return isBiggerThanStandardNumber(getRandomnumber(MIN_NUMBER, MAX_NUMBER));
    }

    boolean isBiggerThanStandardNumber(final int number) {
        return number >= MOVABLE_STANDARD_NUMBER;
    }

    private int getRandomnumber(final int minNumber, final int maxNumber) {
        return new Random().nextInt(maxNumber - MINUS_VALUE) + minNumber;
    }

}
