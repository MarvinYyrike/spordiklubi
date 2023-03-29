import java.time.LocalDate;

public interface Isikud {
    //TODO isik saab osta liikmelisuse, siis muutub isik liikmeks
    public void astubLiikmeks();
    //isik saab laenutada varustust (peab näitama, kas varustust kasutab üritusel või mitte, võib olla üledefineeritud meetodid siis
    public void laenutab(Liikmelisus liige, Spordivahend spordivahend, LocalDate kuupäev, int tasutudTagatisRaha);

    //laenutatud eseme tagasitoomine
    public void tagastab(Spordivahend spordivahend);
    //TODO isik saab osaleda üritusel, osalemiel peab ütlema mitu osalejat seal kokku oli ja siis meetod randomiga väljastab saadud koha võisltusel
    public void osaleb(Isik isik, Yritus nimi);

}
