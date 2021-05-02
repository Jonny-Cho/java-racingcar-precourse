package racingcar;

import racingcar.movestrategy.MoveStrategy;
import racingcar.movestrategy.RandomlyMove;

public class Car {
    static final int ZERO = 0;

    private final CarName name;
    private int distance;
    private final MoveStrategy moveStrategy;

    private Car(final String name, final int distance, final MoveStrategy moveStrategy) {
        this.name = new CarName(name);
        this.distance = distance;
        this.moveStrategy = moveStrategy;
    }

    static Car of(final String name) {
        return of(name, ZERO);
    }

    static Car of(final String name, final int distance) {
        return of(name, distance, new RandomlyMove());
    }

    static Car of(final String name, final MoveStrategy moveStrategy) {
        return new Car(name, ZERO, moveStrategy);
    }

    static Car of(final String name, final int distance, final MoveStrategy moveStrategy) {
        return new Car(name, distance, moveStrategy);
    }

    public void move() {
        if (moveStrategy.canMove()) distance++;
    }

    public int getDistance() {
        return distance;
    }
}
