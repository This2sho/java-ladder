package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    private People people;
    private Prizes ladderResult;
    private Ladder ladder;

    @BeforeEach
    void init() {
        Person pobi = new Person("pobi", 0);
        Person honux = new Person("honux", 1);
        Person crong = new Person("crong", 2);
        Person jk = new Person("jk", 3);

        people = new People(List.of(pobi, honux, crong, jk));
        ladderResult = new Prizes(List.of("꽝", "5000", "꽝", "3000"), people.getCount());
        LadderGenerator testRadderGenerator = (width, height) -> List.of(
            new Line(List.of(true, false, true)),
            new Line(List.of(false, true, false)),
            new Line(List.of(true, false, false)),
            new Line(List.of(false, true, false)),
            new Line(List.of(true, false, true)));
        ladder = Ladder.make(people.getCount(), 5, testRadderGenerator);
    }

    @Test
    @DisplayName("사람 이름을 입력시 그 사람의 결과를 보여준다")
    void searchOneTest() {
        //given
        LadderGame ladderGame = new LadderGame(people, ladderResult, ladder);
        ladderGame.start();

        //when
        LadderResult result = ladderGame.getResult();
        String prize = result.findPrize("pobi");

        //then
        assertThat(prize).isEqualTo("꽝");
    }
}
