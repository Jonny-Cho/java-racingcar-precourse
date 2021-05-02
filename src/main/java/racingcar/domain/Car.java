package racingcar.domain;

import racingcar.movestrategy.MoveStrategy;
import racingcar.movestrategy.RandomlyMove;

import java.util.Objects;


public class Car implements Comparable<Car> {
    static final int ZERO = 0;

    private final CarName name;
    private final MoveStrategy moveStrategy;
    private int distance;

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

    public String getName() {
        return this.name.toString();
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(final Car car) {
        return car.getDistance() - distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", distance=" + distance +
                '}';
    }

}
