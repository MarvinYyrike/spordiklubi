import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
      testiYritusi();

      //Loon spordivahendite inventari listi:

        //Loon mõned spordiesemed, mis on spordiklubil laos olemas ja on võimalik laenutada
        Spordivahend tennisekomplekt = new Spordivahend(true, 40, "tennisekomplekt", 1, 0);
        Spordivahend rannatennisekomplekt = new Spordivahend(true, 30, "rannatennisekomplekt", 2, 0);
        Spordivahend suusakomplekt = new Spordivahend(true, 50, "suusakomplekt", 3, 0);
        Spordivahend õhupüstol = new Spordivahend(true, 300, "õhupüstol", 4, 0);
        Spordivahend noolemääng = new Spordivahend(true, 20, "noolemäng", 5, 0);
        Spordivahend matkauisud = new Spordivahend(true, 250, "matkauisud", 6, 0);


        //To print the Spordivahendid list names
        /*
        List<Spordivahend> list = Spordivahendid.getSpordivahendList();
        for (int i = 0; i < list.size(); i++) {
            Spordivahend spordivahend = list.get(i);
            System.out.println(spordivahend.getNimi());
        }
        */
    }

    private static void testiYritusi() {
        List<Yritus> yritused = new ArrayList<>();
        yritused.add(new Yritus("Paide-Türi rahvajooks 2023", LocalDate.parse("2023-09-24")));
        yritused.add(new Yritus("Viljandi järvejooks 2023", LocalDate.parse("2023-05-01")));

        List<Liige> isikud = new ArrayList<>();
        // Siin peaks see olema veel isik, aga hetkel me ei saa seda tüüpi klassi luua
        isikud.add(new Liige("Pavel", "Loskutov", LocalDate.parse("1963-12-02"), "36912021234", LocalDate.now()));
        isikud.add(new Liige("Kirke", "Kuusik", LocalDate.parse("1988-11-15"), "48811152714", LocalDate.now()));
        isikud.add(new Liige("Kait", "Kuusik", LocalDate.parse("1986-02-02"), "38601022764", LocalDate.now()));

        Osalemised osalemised = new Osalemised();
        osalemised.lisaOsalemine(isikud.get(0), yritused.get(0));
        osalemised.lisaOsalemine(isikud.get(0), yritused.get(1));
        osalemised.lisaOsalemine(isikud.get(1), yritused.get(1));
        osalemised.lisaOsalemine(isikud.get(2), yritused.get(1));

        List<Isik> tulemused = osalemised.tulemusteArvutamine(yritused.get(1));// Viljandi järvejooksu tulemused randomiga
        for (int i = 0; i < tulemused.size(); i++) {
            System.out.println(i + 1 + ". koha sai: " + tulemused.get(i));
        }
    }
}
