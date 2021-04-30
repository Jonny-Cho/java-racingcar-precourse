package racingcar.movestrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AlwaysMoveTest {

    @DisplayName("AlwaysMove의 canMove는 항상 true를 반환한다")
    @Test
    void alwaysTrue() {
        final AlwaysMove alwaysMove = new AlwaysMove();
        assertThat(alwaysMove.canMove()).isTrue();
    }
}
