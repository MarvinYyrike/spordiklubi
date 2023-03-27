import java.time.LocalDate;
import java.util.List;

public class Liige extends Isik{
    private String liikmelisuse_algus; //ISO date format for example 1999-01-08

    public Liige(String liikmelisuse_algus) {
        this.liikmelisuse_algus = liikmelisuse_algus;
    }

    @Override
    public void laenutab(Liige liige, Spordivahend spordivahend, LocalDate kuupäev, int tasutudTagatisRaha) {
        if(spordivahend.isKasLaos() && tasutudTagatisRaha >= spordivahend.getTagatisraha()){
            Laenutamine laenutamine = new Laenutamine(liige, spordivahend, kuupäev);
            laenutamine.getLaenutamineList().add(laenutamine);
            spordivahend.setKasLaos(false);
            spordivahend.setEsemeEestTasutudTagatisraha(tasutudTagatisRaha);
        } else if (!spordivahend.isKasLaos()){
            System.out.println("Eset ei ole laos");
        } else if(tasutudTagatisRaha < spordivahend.getTagatisraha()){
            System.out.println("Tasutud tagatisraha on liiga väike");
        }

    }

    @Override
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
