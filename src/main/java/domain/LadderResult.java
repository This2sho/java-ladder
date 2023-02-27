package domain;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class LadderResult implements Iterable<Entry<String, String>> {

    private final Map<String, String> map;

    public LadderResult(Map<String, String> map) {
        this.map = map;
    }

    public String findPrize(String personName) {
        validatePersonName(personName);
        return map.get(personName);
    }

    private void validatePersonName(String personName) {
        if (!map.containsKey(personName)) {
            throw new IllegalArgumentException("존재하지 않는 사람 이름입니다");
        }
    }

    @Override
    public Iterator<Entry<String, String>> iterator() {
        return map.entrySet().iterator();
    }
}
