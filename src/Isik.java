import java.time.LocalDate;

public abstract class Isik implements Isikud{
    private String eesnimi;
    private String perenimi;
    private String synniaeg; //ISO date format for example 1999-01-08
    private String isikukood;

    @Override
    public void astubLiikmeks() {

    }
    @Override
    public abstract void laenutab(Liige liige, Spordivahend spordivahend, LocalDate kuupäev, int tasutudTagatisRaha);

    @Override
    public void osaleb() {

    }
    @Override
    public abstract void tagastab(Spordivahend spordivahend);
}
