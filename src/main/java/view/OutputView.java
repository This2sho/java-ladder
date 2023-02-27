package view;

import domain.Ladder;
import domain.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OutputView {

    public static final String DELIMITER = "|";
    public static final String FIND_ALL_COMMAND = "all";

    public static void printNames(List<String> names) {
        names.forEach((name) -> System.out.printf("%5s ", name));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            List<String> lineShape = getLineShape(line.getMovements());
            System.out.printf("    |%s|%n", String.join(DELIMITER, lineShape));
        }
    }

    private static List<String> getLineShape(List<Boolean> points) {
        List<String> lineShape = new ArrayList<>();
        for (Boolean point : points) {
            lineShape.add(LineType.getMessageByMovable(point));
        }
        return lineShape;
    }

    public static void printError(Exception exception) {
        System.out.printf("[ERROR] : %s%n", exception.getMessage());
    }

    public static void printCriticalError(Exception exception) {
        System.out.println("예기치 못한 에러가 발생했습니다.");
        System.out.println(exception.getMessage());
    }

    public static void printResult(Map<String, String> ladderResult, String personName) {
        System.out.println("실행결과");
        if (FIND_ALL_COMMAND.equals(personName)) {
            Set<Entry<String, String>> entries = ladderResult.entrySet();
            for (Entry<String, String> entry : entries) {
                System.out.printf("%s : %s%n", entry.getKey(), entry.getValue());
            }
            return;
        }
        System.out.println(ladderResult.get(personName));
    }
}
