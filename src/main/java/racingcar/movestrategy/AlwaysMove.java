package racingcar.movestrategy;

public class AlwaysMove implements MoveStrategy {
    @Override
    public boolean canMove() {
        return true;
    }
}
