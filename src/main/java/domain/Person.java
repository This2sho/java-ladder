package domain;

public class Person {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;
    public static final String NAME_LENGTH_FORMAT = "이름은 %d자 이상 %d자 이하여야 합니다";

    private final String name;

    public Person(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.isBlank() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                String.format(NAME_LENGTH_FORMAT, MIN_LENGTH, MAX_LENGTH));
        }
    }

    public String getName() {
        return name;
    }
}
