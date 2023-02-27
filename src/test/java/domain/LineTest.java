package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineTest {

    @Test
    @DisplayName("true가 연속으로 두 개 나오면 예외를 발생시킨다.")
    void exceptionTest() {
        assertThatThrownBy(() -> new Line(List.of(true, true, false)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("가로라인이 연속될 수 없습니다.");
    }

    @Test
    @DisplayName("true가 연속으로 두 개 나오지 않아야 한다.")
    void succeedTest() {
        assertDoesNotThrow(() -> new Line(List.of(true, false, false)));
    }

    @DisplayName("해당 인덱스가 line의 크기보다 작고 해당 인덱스의 boolean이 true이면 true를 반환한다.")
    @ParameterizedTest(name = "{index} : {0}을 넣으면 {1}을 반환한다.")
    @CsvSource({"0, true", "1, false", "2, true", "3, false"})
    void canGoRight(int widthIndex, boolean expected) {
        //given
        Line line = new Line(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));
        //when
        boolean actual = line.canGoRight(widthIndex);
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("해당 인덱스가 1이상이고 이전 인덱스의 boolean이 true이면 true를 반환한다")
    @ParameterizedTest(name = "{index} : {0}을 넣으면 {1}을 반환한다.")
    @CsvSource({"0, false", "1, true", "2, false", "3, true"})
    void canGoLeft(int widthIndex, boolean expected) {
        //given
        Line line = new Line(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));
        //when
        boolean actual = line.canGoLeft(widthIndex);
        //then
        assertThat(actual).isEqualTo(expected);
    }
}
