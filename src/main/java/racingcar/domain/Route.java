package racingcar.domain;

import racingcar.movestrategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private final List<Cars> carRoutes = new ArrayList<>();

    public void record(final Cars cars, final MoveStrategy moveStrategy) {
        this.carRoutes.add(new Cars(cars.cloneCars(), moveStrategy));
    }

    public List<Cars> getCarRoutes() {
        return carRoutes;
    }

    @Override
    public String toString() {
        return "Route{" +
                "carRoutes=" + carRoutes +
                '}';
    }
}
