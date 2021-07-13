package racing;

public class Racer {
    private String name;
    private int position;

    private Racer(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Racer of(String name, int position) {
        return new Racer(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
