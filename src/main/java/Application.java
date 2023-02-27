import static view.InputView.DELIMITER;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderResult;
import domain.People;
import domain.Person;
import domain.Prizes;
import domain.RandomLadderGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        People people = repeat(this::nameRequest);
        Prizes prizes = repeat(() -> prizesRequest(people.getCount()));
        Ladder ladder = repeat(() -> ladderRequest(people.getCount()));
        LadderGame ladderGame = new LadderGame(people, prizes, ladder);

        showGameStatus(people, prizes, ladder);
        ladderGame.start();
        LadderResult result = ladderGame.getResult();
        repeat(() -> showResult(result));
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            return repeat(inputReader);
        } catch (Exception exception) {
            OutputView.printCriticalError(exception);
            return repeat(inputReader);
        }
    }

    private void repeat(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            repeat(runnable);
        } catch (Exception exception) {
            OutputView.printCriticalError(exception);
            repeat(runnable);
        }
    }

    private People nameRequest() {
        String inputNames = InputView.readNames();

        List<String> names = convertToList(inputNames);

        AtomicInteger index = new AtomicInteger();
        List<Person> people = names.stream()
            .map((name) -> new Person(name, index.getAndIncrement()))
            .collect(Collectors.toList());
        return new People(people);
    }

    private List<String> convertToList(String inputs) {
        return Arrays.stream(inputs.split(DELIMITER))
            .collect(Collectors.toList());
    }

    private Prizes prizesRequest(int peopleCount) {
        String inputPrizes = InputView.readResults();

        List<String> prizes = convertToList(inputPrizes);
        return new Prizes(prizes, peopleCount);
    }

    private Ladder ladderRequest(int peopleCount) {
        int height = InputView.readLadderHeight();
        return Ladder.make(peopleCount, height, new RandomLadderGenerator());
    }

    private void showGameStatus(People people, Prizes prizes, Ladder ladder) {
        OutputView.printNames(people.getNames());
        OutputView.printLadder(ladder);
        OutputView.printNames(prizes.getPrizes());
    }

    private void showResult(LadderResult result) {
        String personName = InputView.readPersonName();
        OutputView.printResult(result, personName);
    }
}
