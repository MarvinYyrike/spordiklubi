import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    //Loon mõned spordiesemed, mis on spordiklubil laos olemas ja on võimalik laenutada
    Spordivahend tennisekomplekt = new Spordivahend(true, 40, "tennisekomplekt", 1, 0);
    Spordivahend rannatennisekomplekt = new Spordivahend(true, 30, "rannatennisekomplekt", 2, 0);
    Spordivahend suusakomplekt = new Spordivahend(true, 50, "suusakomplekt", 3, 0);
    Spordivahend õhupüstol = new Spordivahend(true, 300, "õhupüstol", 4, 0);
    Spordivahend noolemääng = new Spordivahend(true, 20, "noolemäng", 5, 0);
    Spordivahend matkauisud = new Spordivahend(true, 250, "matkauisud", 6, 0);

    Liikmed liikmed = new Liikmed();

    Isik aktiivneIsik = null;

    // testiYritusi();
    //Scanneriga küsi infot osalemiste ja ürituste kohta.
    //Scanneriga sisesta uus üritusel osalemine.
    // Liides, kus saab valida, mida sisestada soovitakse.
    int valik = 0;
    while (valik != 4) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Mida soovid teha?");
      System.out.println();
      System.out.println("1 - Sisestada üritusel osalemist.");
      System.out.println("2 - Otsida üritusi, kus isik on osalenud.");
      System.out.println("3 - Vaadata kõiki üritusel osalenuid.");
      System.out.println("4 - Väljuda.");
      System.out.println("5 - Näha laenutatavaid esemeid");
      System.out.println("6 - laenuta ese: (kõigepealt vajuta 6 (enne pead olema spordivahendeid vaadanud) siis sisesta oma andmed ja astu liikmeks");
      System.out.println("7 - tagasta ese");
      System.out.println("8 - loo uus konto (uue isiku tekitamine programmi)");
      System.out.println("9 - vaheta kontot");

      valik = scan.nextInt();
      switch (valik) {
        case 1:
          if (aktiivneIsik == null) {
            aktiivneIsik = looVoiValiIsik(liikmed);
            break;
          }
          //uus ürituse ja isiku ühendus
          break;
        case 2:
          //läheb isiku üritusi otsima
          break;
        case 3:
          //läheb üritusel osalenuid otsima
          break;
        case 4:
          System.out.println("Väljusid süsteemist.");
          break;
        case 5:
          vaataSpordivahendeid();
          break;
        case 6:
          //vaataSpordivahendeid();
          Spordivahend valitudSpordivahend1 = otsiSpordivahend();
          if (valitudSpordivahend1 == null) {
            break;
          }
          if (aktiivneIsik == null) {
            aktiivneIsik = looVoiValiIsik(liikmed);
            break;
          }
          Laenutamine laenutamine = new Laenutamine(aktiivneIsik, valitudSpordivahend1, LocalDate.now());
          laenutamine.addLaenutus(laenutamine);

          break;
        case 7:
          // tagasta ese
          System.out.println("Kes tagastab:");
          Isik isik = looIsik(liikmed);
          Spordivahend valitudSpordivahend2 = otsiSpordivahend();
          isik.tagastab(valitudSpordivahend2);

          break;
        case 8:
          //loo uus isik programmi
          aktiivneIsik = looIsik(liikmed);
          break;
        case 9:
          //vaheta isikut
          aktiivneIsik = looVoiValiIsik(liikmed);
          break;


        default:
          System.out.println("Sisestamisel läks midagi valesti, proovi palun uuesti.");

      }
    }


  }

  private static Isik looVoiValiIsik(Liikmed liikmed) {
    if (!liikmed.onLiikmeid()) {
      System.out.println("Kuna klubil pole ühtegi liiget, siis palun sisesta esimene:");
      return looIsik(liikmed);
    }
    System.out.println("Vali isik klubi liikmete seast:");

    liikmed.kuvaLiikmed();

    System.out.println("Sisesta liikme number");
    int number = 0;
    Isik aktiivneIsik = null;
    while (aktiivneIsik == null) {
      Scanner scan = new Scanner(System.in);
      number = scan.nextInt();
      aktiivneIsik = liikmed.otsiIsikNumbriJargi(number);
      if (aktiivneIsik == null) {
        System.out.println("Sellise numbriga isikut ei leitud, palun proovi uuesti");
      }
    }
    return aktiivneIsik;
  }

  public static Isik otsiIsikEesnimega(Liikmed liikmed) {
    System.out.println("Sisesta, millist isikut otsid");
    Scanner scanner = new Scanner(System.in);
    String isikEesnimi = scanner.next();
    System.out.println("Otsin isikut:: " + isikEesnimi);

    Isik valitudIsik = liikmed.otsiIsikEesnimega(isikEesnimi);
    if (valitudIsik == null) {
      System.out.println("Sellist isikut ei ole...");
    }
    return valitudIsik;
  }

  public static Spordivahend otsiSpordivahend() {
    System.out.println("Sisesta, mida tahad laenutada/tagastada");
    Scanner scanner = new Scanner(System.in);
    String spordivahendiNimi = scanner.next();
    System.out.println("Võtan eseme: " + spordivahendiNimi);
    List<Spordivahend> spordivahendid = Spordivahendid.getSpordivahendList();
    Spordivahend valitudSpordivahend = null;
    for (Spordivahend spordivahend : spordivahendid) {
      if (spordivahendiNimi.equalsIgnoreCase(spordivahend.getNimi())) {
        valitudSpordivahend = spordivahend;
      }
    }
    if (valitudSpordivahend == null) {
      System.out.println("Sellist eset ei ole...");
    }
    return valitudSpordivahend;
  }

  public static Isik looIsik(Liikmed liikmed) {
    System.out.println("Eesnimi:");
    Scanner scannerEesnimi = new Scanner(System.in);
    String eesnimi = scannerEesnimi.next();
    System.out.println("Perenimi:");
    Scanner scannerPerenimi = new Scanner(System.in);
    String perenimi = scannerPerenimi.next();
    System.out.println("Synniaeg yyyy-mm-dd");
    LocalDate synniaeg = null;
    while(synniaeg == null) {
      Scanner scannerSynniaeg = new Scanner(System.in);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      try {
        synniaeg = LocalDate.parse(scannerSynniaeg.next(), formatter);
      } catch(DateTimeException e) {
        System.out.println("Vigane sünniaeg, palun sisesta uuesti kujul yyyy-mm-dd");
      }
    }
    System.out.println("Isikukood:");
    Scanner scannerIsikukood = new Scanner(System.in);
    String isikokood = scannerIsikukood.next();

    Isik isik = new Isik(eesnimi, perenimi, synniaeg, isikokood);
    liikmed.lisaLiikmeks(isik);
    return isik;
  }

  private static void vaataSpordivahendeid() {
    //To print the Spordivahendid list names
    List<Spordivahend> list = Spordivahendid.getSpordivahendList();
    for (int i = 0; i < list.size(); i++) {
      Spordivahend spordivahend = list.get(i);
      System.out.println(spordivahend.getNimi());
    }
  }

  private static void testiYritusi() {
    List<Yritus> yritused = new ArrayList<>();
    yritused.add(new Yritus("Paide-Türi rahvajooks 2023", LocalDate.parse("2023-09-24")));
    yritused.add(new Yritus("Viljandi järvejooks 2023", LocalDate.parse("2023-05-01")));

    List<Isik> isikud = new ArrayList<>();
    // Siin peaks see olema veel isik, aga hetkel me ei saa seda tüüpi klassi luua
    isikud.add(new Isik("Pavel", "Loskutov", LocalDate.parse("1963-12-02"), "36912021234"));
    isikud.add(new Isik("Kirke", "Kuusik", LocalDate.parse("1988-11-15"), "48811152714"));
    isikud.add(new Isik("Kait", "Kuusik", LocalDate.parse("1986-02-02"), "38601022764"));

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
