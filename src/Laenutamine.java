import java.time.LocalDate;

//Antud klass hoiab ühte laenutamise objekti (üks inimene laenutab ühe eseme)
public class Laenutamine extends Laenutamised{
    private Isik isik;
    private Spordivahend spordivahend;
    private LocalDate laenutamisKuupäev;

    public Laenutamine(Isik liige, Spordivahend spordivahend, LocalDate laenutamisKuupäev) {
        this.isik = isik;
        this.spordivahend = spordivahend;
        this.laenutamisKuupäev = laenutamisKuupäev;

    }
    public void addLaenutus(Laenutamine laenutamine){

        laenutamine.getLaenutamineList().add(laenutamine);
    }
}
