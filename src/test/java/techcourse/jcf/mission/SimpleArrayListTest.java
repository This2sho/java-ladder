package techcourse.jcf.mission;

import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    @Test
    void add() {
        //given
        SimpleArrayList simpleArrayList = new SimpleArrayList(1);

        System.out.println(simpleArrayList.size());
        simpleArrayList.add("a");
        System.out.println(simpleArrayList.size());
        //when
        simpleArrayList.add("b");
        System.out.println(simpleArrayList.size());

        simpleArrayList.add("b");
        System.out.println(simpleArrayList.size());
        simpleArrayList.add("b");
        System.out.println(simpleArrayList.size());
        //then

    }
}
