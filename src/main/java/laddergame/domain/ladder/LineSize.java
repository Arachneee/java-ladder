package laddergame.domain.ladder;

import java.util.Objects;
import laddergame.domain.name.Names;
import laddergame.exception.LadderGameException;

public class LineSize {

    private final int value;

    public LineSize(final Names names) {
        validateSize(names);
        this.value = names.size() - 1;
    }

    private void validateSize(final Names names) {
        if (names == null || names.size() == 0) {
            throw new LadderGameException("[ERROR] 참가자는 1명 이상이어야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final LineSize lineSize1)) {
            return false;
        }
        return getValue() == lineSize1.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
