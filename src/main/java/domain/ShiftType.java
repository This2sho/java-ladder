package domain;

import java.util.function.Function;

public enum ShiftType {
    LEFT(Position::minus),
    RIGHT(Position::plus),
    NO((p) -> p);

    private final Function<Position, Position> function;

    ShiftType(Function<Position, Position> function) {
        this.function = function;
    }

    public Position apply(Position position) {
        return function.apply(position);
    }
}
