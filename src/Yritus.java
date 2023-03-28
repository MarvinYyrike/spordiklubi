import java.util.Objects;

public class Yritus {
    private String nimi;
    private String toimumisaeg;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Yritus yritus)) return false;
        return nimi.equals(yritus.nimi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nimi);
    }
}
