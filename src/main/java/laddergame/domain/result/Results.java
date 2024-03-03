package laddergame.domain.result;

import java.util.List;
import laddergame.domain.ladder.Position;

public class Results {

    private final List<Result> values;

    public Results(final List<String> values, final int size) {
        validateSize(values, size);

        this.values = values.stream()
                .map(Result::new)
                .toList();
    }

    private void validateSize(final List<String> values, final int size) {
        if (values.size() != size) {
            throw new IllegalArgumentException("[ERROR] 결과 수를 " + size + "개 입력해주세요.");
        }
    }

    public int size() {
        return values.size();
    }

    public Result get(final Position resultPosition) {
        return values.get(resultPosition.getValue());
    }

    public List<Result> getValues() {
        return values;
    }
}
