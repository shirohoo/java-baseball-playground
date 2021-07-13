package racing;

import java.util.Iterator;
import java.util.List;

public class Racers {
    private final List<Racer> racers;

    public Racers(List<Racer> racers) {
        this.racers = racers;
    }

    public int size() {
        return racers.size();
    }

    public Racer getRacer(final int index) {
        return racers.get(index);
    }

    public Iterator<Racer> iterator() {
        return racers.iterator();
    }
}
