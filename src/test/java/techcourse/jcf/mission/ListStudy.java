package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ListStudy {

    @Test
    public void arrayList() {
        SimpleArrayList values = new SimpleArrayList();
        values.add("first");
        values.add("second");

        assertThat(values.add("three")).isTrue();
        assertThat(values.size()).isEqualTo(3);
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.contains("first")).isTrue();
        assertThat(values.remove(0)).isEqualTo("first");
        assertThat(values.size()).isEqualTo(2);
    }

    @Test
    public void LinkedList() {
        SimpleLinkedList values = new SimpleLinkedList();
        values.add("first");
        values.add("second");

        assertThat(values.add("three")).isTrue();
        assertThat(values.size()).isEqualTo(3);
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.contains("first")).isTrue();
        assertThat(values.remove(0)).isEqualTo("first");
        assertThat(values.size()).isEqualTo(2);
    }
}
