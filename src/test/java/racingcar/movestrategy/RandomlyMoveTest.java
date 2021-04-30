package racingcar.movestrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.movestrategy.RandomlyMove.MOVABLE_STANDARD_NUMBER;

class RandomlyMoveTest {

    @DisplayName("MOVABLE_STANDARD_NUMBER 이상이면 true 아니면 false를 반환한다")
    @Test
    void isBiggerThanStandardNumber() {
        final RandomlyMove randomlyMove = new RandomlyMove();
        assertThat(randomlyMove.isBiggerThanStandardNumber(MOVABLE_STANDARD_NUMBER - 1)).isFalse();
        assertThat(randomlyMove.isBiggerThanStandardNumber(MOVABLE_STANDARD_NUMBER)).isTrue();
        assertThat(randomlyMove.isBiggerThanStandardNumber(MOVABLE_STANDARD_NUMBER + 1)).isTrue();
    }

}
