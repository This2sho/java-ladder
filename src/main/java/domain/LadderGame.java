package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final People people;
    private final Prizes prizes;
    private final Ladder ladder;

    public LadderGame(People people, Prizes prizes, Ladder ladder) {
        this.people = people;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public void start() {
        for (Person person : people.getPeople()) {
            move(person);
        }
    }

    private void move(Person person) {
        for (int heightIndex = 0; heightIndex < ladder.getHeight(); heightIndex++) {
            int currentPosition = person.getPosition().getValue();
            ShiftType shiftType = ladder.findShiftType(currentPosition, heightIndex);
            person.move(shiftType);
        }
    }

    public LadderResult getResult() {
        Map<String, String> map = new LinkedHashMap<>();
        this.people.getPeople()
            .forEach((p) -> {
                String prize = searchPrizeByPerson(p);
                map.put(p.getName(), prize);
            });
        return new LadderResult(map);
    }

    private String searchPrizeByPerson(Person person) {
        int personIndex = person.getPosition()
            .getValue();
        return prizes.getPrize(personIndex);
    }
}
