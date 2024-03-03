package laddergame.domain.name;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import laddergame.domain.ladder.Position;

public class Names {

    private final List<Name> values;

    public Names(final List<String> input) {
        validateSize(input);
        final List<Name> names = convertToNames(input);
        validateDuplication(names);

        this.values = names;
    }

    private void validateSize(final List<String> input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 참가자는 1명이상이어야 합니다.");
        }
    }

    private List<Name> convertToNames(final List<String> input) {
        return input.stream()
                .map(Name::new)
                .toList();
    }

    private void validateDuplication(final List<Name> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException("[ERROR] 이름은 중복 될 수 없습니다.");
        }
    }

    public int size() {
        return values.size();
    }

    public Name get(final Position namePosition) {
        return values.get(namePosition.getValue());
    }

    public List<Name> getValues() {
        return Collections.unmodifiableList(values);
    }
}
