import java.time.LocalDate;
import java.util.Objects;

public abstract class Isik implements Isikud{
    private String eesnimi;
    private String perenimi;
    private LocalDate synniaeg;
    private String isikukood;

    public Isik(String eesnimi, String perenimi, LocalDate synniaeg, String isikukood) {
        this.eesnimi = eesnimi;
        this.perenimi = perenimi;
        this.synniaeg = synniaeg;
        this.isikukood = isikukood;
    }

    public String getEesnimi() {
        return eesnimi;
    }

    public void setEesnimi(String eesnimi) {
        this.eesnimi = eesnimi;
    }

    public String getPerenimi() {
        return perenimi;
    }

    public void setPerenimi(String perenimi) {
        this.perenimi = perenimi;
    }

    public LocalDate getSynniaeg() {
        return synniaeg;
    }

    public void setSynniaeg(LocalDate synniaeg) {
        this.synniaeg = synniaeg;
    }

    public String getIsikukood() {
        return isikukood;
    }

    public void setIsikukood(String isikukood) {
        this.isikukood = isikukood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Isik isik)) return false;
        return Objects.equals(isikukood, isik.isikukood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isikukood);
    }

    @Override
    public void astubLiikmeks() {
        Liige liige = new Liige(eesnimi, perenimi, synniaeg, isikukood, LocalDate.now());

    }
    @Override
    public abstract void laenutab(Liige liige, Spordivahend spordivahend, LocalDate kuupäev, int tasutudTagatisRaha);

    @Override
    public void osaleb(Isik isik, Yritus yritus) {
        

    }
    @Override
    public abstract void tagastab(Spordivahend spordivahend);
}
