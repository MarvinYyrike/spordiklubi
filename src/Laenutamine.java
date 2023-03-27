import java.time.LocalDate;

//Antud klass hoiab ühte laenutamise objekti (üks inimene laenutab ühe eseme)
public class Laenutamine extends Laenutamised{
    private Liige liige;
    private Spordivahend spordivahend;
    private LocalDate laenutamisKuupäev;

    public Laenutamine(Liige liige, Spordivahend spordivahend, LocalDate laenutamisKuupäev) {
        super();
        this.liige = liige;
        this.spordivahend = spordivahend;
        this.laenutamisKuupäev = laenutamisKuupäev;

    }
    public void addLaenutus(Laenutamine laenutamine){

        laenutamine.getLaenutamineList().add(laenutamine);
    }
}
