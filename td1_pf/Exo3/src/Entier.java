import java.util.Objects;

public class Entier implements Sommable<Entier>, Comparable<Entier> {
    private final Integer val;

    public Entier(final Integer val) {
        this.val = val;
    }

    @Override
    public Entier sommer(Entier v) {
        return new Entier(this.val + v.getVal());
    }

    public Integer getVal() {
        return val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Entier entier = (Entier) o;
        return Objects.equals(val, entier.val);
    }


    @Override
    public String toString() {
        return "Entier[" +
                "val=" + val +
                ']';
    }

    @Override
    public int compareTo(Entier autre) {
        return this.val.compareTo(autre.getVal());
    }
}
