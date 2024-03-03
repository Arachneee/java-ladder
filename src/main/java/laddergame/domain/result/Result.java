package laddergame.domain.result;

import java.util.Objects;

public class Result {

    private final String value;

    public Result(final String value) {
        validateEmpty(value);
        this.value = value;
    }

    private void validateEmpty(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 결과를 입력할 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Result result1)) {
            return false;
        }
        return Objects.equals(value, result1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
