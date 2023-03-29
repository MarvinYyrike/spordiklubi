import java.time.LocalDate;
import java.util.List;

public class Liikmelisus {
    private LocalDate liikmelisuseAlgus;
    private List<Isik> isik;

    public Liikmelisus(LocalDate liikmelisuseAlgus, List<Isik> isik) {
        this.liikmelisuseAlgus = liikmelisuseAlgus;
        this.isik = isik;
    }

    public LocalDate getLiikmelisuseAlgus() {
        return liikmelisuseAlgus;
    }

    public void setLiikmelisuseAlgus(LocalDate liikmelisuseAlgus) {
        this.liikmelisuseAlgus = liikmelisuseAlgus;
    }

    public List<Isik> getIsik() {
        return isik;
    }

    public void setIsik(List<Isik> isik) {
        this.isik = isik;
    }
}
