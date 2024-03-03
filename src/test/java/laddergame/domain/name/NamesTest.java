package laddergame.domain.name;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesTest {


    @DisplayName("이름이 중복되면 예외를 발생시킨다.")
    @Test
    void duplicatedName() {
        final List<String> values = List.of("zeze", "zeze");

        assertThatThrownBy(() -> new Names(values))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 중복 될 수 없습니다.");
    }

    @DisplayName("빈 값이면 예외를 발생시킨다.")
    @Test
    void empty() {
        final List<String> values = List.of();

        assertThatThrownBy(() -> new Names(values))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참가자는 1명이상이어야 합니다.");
    }
}
