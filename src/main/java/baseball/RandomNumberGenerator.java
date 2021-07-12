package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class RandomNumberGenerator {
    private static final int MIN = 1;
    private static final int MAX = 9;

    static String generate() {
        Set<Integer> set = new HashSet<>();
        Random random = new Random();

        while (set.size() < 3) {
            set.add(random.nextInt(MAX) + MIN);
        }

        StringBuilder stringBuilder = new StringBuilder();
        set.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
