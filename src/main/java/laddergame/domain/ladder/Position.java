package laddergame.domain.ladder;

import java.util.Objects;
import laddergame.exception.LadderGameException;

public class Position {

    private final int value;

    public Position(final int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(final int value) {
        if (value < 0) {
            throw new LadderGameException("[ERROR] 음수를 포지션으로 가질 수 없습니다.");
        }
    }

    public Position increase() {
        return new Position(value + 1);
    }

    public Position decrease() {
        return new Position(value - 1);
    }

    public boolean isGreaterThan(final int size) {
        return value > size;
    }

    public boolean isNot(final int value) {
        return this.value != value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Position position1)) {
            return false;
        }
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
