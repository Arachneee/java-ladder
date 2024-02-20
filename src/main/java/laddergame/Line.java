package laddergame;

import java.util.ArrayList;
import java.util.List;
import laddergame.exception.LadderLineOverlappedException;

public class Line {

    private final List<Boolean> points;

    private Line(final int personSize, final BooleanGenerator booleanGenerator) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < personSize - 1; i++) {
            points.add(booleanGenerator.generate());
        }

        validateOverlap(points);

        this.points = points;
    }

    public static Line create(final int personSize, final BooleanGenerator booleanGenerator) {
        return new Line(personSize, booleanGenerator);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private void validateOverlap(final List<Boolean> points) {
        // TODO : 인뎁스 줄이기
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i) && points.get(i + 1)) {
                throw new LadderLineOverlappedException("[ERROR] 가로 라인이 겹치면 안됩니다.");
            }
        }
    }



    public int getSize() {
        return points.size();
    }
}
