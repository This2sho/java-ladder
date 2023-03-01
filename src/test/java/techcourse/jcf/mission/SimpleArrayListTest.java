package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {
    private SimpleArrayList simpleArrayList;

    @BeforeEach
    void init() {
        simpleArrayList = new SimpleArrayList(1);
        simpleArrayList.add("first");
        simpleArrayList.add("second");
    }

    @Test
    void add() {
        assertThat(simpleArrayList.add("three")).isTrue();
    }

    @Test
    void set() {
        String newValue = "set";
        String oldValue = simpleArrayList.set(0, newValue);
        assertThat(simpleArrayList.get(0)).isEqualTo(newValue);
        assertThat(oldValue).isEqualTo("first");
    }

    @Test
    void get() {
        assertThat(simpleArrayList.get(0)).isEqualTo("first");
    }

    @Test
    void contains() {
        assertThat(simpleArrayList.contains("first")).isTrue();
    }

    @Test
    void indexOf() {
        simpleArrayList.add(1, "two");
        simpleArrayList.add(1, "two2");

        for (int i = 0; i < simpleArrayList.size(); i++) {
            System.out.println(simpleArrayList.get(i));
        }
    }

    @Test
    void size() {
        assertThat(simpleArrayList.size()).isEqualTo(2);
    }

    @Test
    void isEmpty() {
        assertThat(simpleArrayList.isEmpty()).isFalse();
    }

    @Test
    void remove() {
        assertThat(simpleArrayList.remove(0)).isEqualTo("first");
    }

    @Test
    void clear() {
        simpleArrayList.clear();
        assertThat(simpleArrayList.size()).isEqualTo(0);
    }
}
