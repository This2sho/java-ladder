package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    private SimpleList simpleLinkedList;

    @BeforeEach
    void init() {
        simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.add("first");
        simpleLinkedList.add("second");
    }

    @Test
    void add() {
        assertThat(simpleLinkedList.add("three")).isTrue();
    }

    @Test
    void set() {
        String newValue = "set";
        String oldValue = simpleLinkedList.set(0, newValue);
        assertThat(simpleLinkedList.get(0)).isEqualTo(newValue);
        assertThat(oldValue).isEqualTo("first");
    }

    @Test
    void get() {
        assertThat(simpleLinkedList.get(0)).isEqualTo("first");
    }

    @Test
    void contains() {
        assertThat(simpleLinkedList.contains("first")).isTrue();
    }

    @Test
    void indexOf() {
        simpleLinkedList.add(1, "two");
        simpleLinkedList.add(1, "two2");

        for (int i = 0; i < simpleLinkedList.size(); i++) {
            System.out.println(simpleLinkedList.get(i));
        }
    }

    @Test
    void size() {
        assertThat(simpleLinkedList.size()).isEqualTo(2);
    }

    @Test
    void isEmpty() {
        assertThat(simpleLinkedList.isEmpty()).isFalse();
    }

    @Test
    void remove() {
        assertThat(simpleLinkedList.remove(0)).isEqualTo("first");
    }

    @Test
    void clear() {
        simpleLinkedList.clear();
        assertThat(simpleLinkedList.size()).isEqualTo(0);
    }
}
