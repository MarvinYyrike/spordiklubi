import java.time.LocalDate;
import java.util.List;

public class Liikmelisus {
    private LocalDate liikmelisuseAlgus;
    private Isik isik;


    public Liikmelisus(LocalDate liikmelisuseAlgus, Isik isik) {
        this.liikmelisuseAlgus = liikmelisuseAlgus;
        this.isik = isik;
    }

    public LocalDate getLiikmelisuseAlgus() {
        return liikmelisuseAlgus;
    }

    public void setLiikmelisuseAlgus(LocalDate liikmelisuseAlgus) {
        this.liikmelisuseAlgus = liikmelisuseAlgus;
    }

    public Isik getIsik() {
        return isik;
    }

    public void laenutab(Spordivahend spordivahend, LocalDate kuupäev, int tasutudTagatisRaha) {
        if(spordivahend.isKasLaos() && tasutudTagatisRaha >= spordivahend.getTagatisraha()){
            Laenutamine laenutamine = new Laenutamine(isik, spordivahend, kuupäev);
            laenutamine.getLaenutamineList().add(laenutamine);
            spordivahend.setKasLaos(false);
            spordivahend.setEsemeEestTasutudTagatisraha(tasutudTagatisRaha);
        } else if (!spordivahend.isKasLaos()){
            System.out.println("Eset ei ole laos");
        } else if(tasutudTagatisRaha < spordivahend.getTagatisraha()){
            System.out.println("Tasutud tagatisraha on liiga väike");
        }

    }

    public void tagastab(Spordivahend spordivahend) {

        //randomiga valime laokoha (0-99), tsekime kas see on vaba ning kui on vaba, siis paneme laokohale
        int laokoht = (int) (Math.random() * 100);
        List<Spordivahend> spordivahendList = spordivahend.getSpordivahendList();
        //boolean containsAge35 = people.stream().anyMatch(person -> person.getAge() == 35); chat-GPT abil küsitud näide
        boolean kasLaokohtKinni = spordivahendList.stream().anyMatch(spordivahend_x -> spordivahend_x.getLaokoht() == laokoht);

        if(kasLaokohtKinni){
            tagastab(spordivahend);
        } else {
            spordivahend.setKasLaos(true);
            spordivahend.setEsemeEestTasutudTagatisraha(0);
            System.out.println("Tagastame tagatisraha, " + spordivahend.getEsemeEestTasutudTagatisraha() + " eurot!");
            spordivahend.setLaokoht(laokoht);
        }

    }
}
