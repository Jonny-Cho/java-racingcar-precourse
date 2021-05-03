package racingcar.view.input;

import java.util.List;

public interface Input {

    void println(final String message);

    List<String> getCarNames();

    int getTryCount();

}
