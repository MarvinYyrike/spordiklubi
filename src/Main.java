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


    // testiYritusi();
    // testiSpordivahendeid();
    //Scanneriga küsi infot osalemiste ja ürituste kohta.
    //Scanneriga sisesta uus üritusel osalemine.
    // Liides, kus saab valida, mida sisestada soovitakse.
    int valik = 0;
    while (valik != 4) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Mida soovid teha?");
      System.out.println();
      System.out.println("1- Sisestada üritusel osalemist.");
      System.out.println("2- Otsida üritusi, kus isik on osalenud.");
      System.out.println("3- Vaadata kõiki üritusel osalenuid.");
      System.out.println("4- Väljuda.");
      System.out.println("5 - Näha laenutatavaid esemeid");
      System.out.println("6 - laenuta ese: (kõigepealt vajuta 6 (enne pead olema spordivahendeid vaadanud) siis sisesta oma andmed ja astu liikmeks");
      System.out.println("7 - loo uus konto (uue isiku tekitamine porgrammi)");
      System.out.println("8 - tagasta ese");

      valik = scan.nextInt();
      switch (valik) {
        case 1:
          //uus ürituse ja isiku ühendus
          //uus isik?
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
          if(valitudSpordivahend1==null){
            break;
          }

          Laenutamine laenutamine = new Laenutamine(looIsik(),valitudSpordivahend1, LocalDate.now());
          laenutamine.addLaenutus(laenutamine);

          break;
        case 7:
          //loo uus isik programmi
          looIsik();
          break;
        case 8:
          // tagasta ese
          System.out.println("Kes tagastab:");
          Isik isik = looIsik();
          Spordivahend valitudSpordivahend2 = otsiSpordivahend();
          isik.tagastab(valitudSpordivahend2);
          break;

        default:
          System.out.println("Sisestamisel läks midagi valesti, proovi palun uuesti.");

      }
    }


  }
  public static Isik otsiIsikEesnimega(){
    System.out.println("Sisesta, millist isikut otsid");
    Scanner scanner = new Scanner(System.in);
    String isikEesnimi = scanner.next();
    System.out.println("Otsin isikut:: " + isikEesnimi);
    List<Isik> isikud = Liikmed.getLiikmed();
    Isik valitudIsik = null;
    for (Isik isik : isikud) {
      if (isik.getEesnimi().equals(isikEesnimi)) {
        valitudIsik = isik;
      }
    }
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
      if (spordivahendiNimi.equals(spordivahend.getNimi())) {
        valitudSpordivahend = spordivahend;
      }
    }
    if (valitudSpordivahend == null) {
      System.out.println("Sellist eset ei ole...");
    }
      return valitudSpordivahend;
  }

  public static Isik looIsik(){
    System.out.println("Eesnimi:");
    Scanner scannerEesnimi = new Scanner(System.in);
    String eesnimi =  scannerEesnimi.next();
    System.out.println("Perenimi:");
    Scanner scannerPerenimi = new Scanner(System.in);
    String perenimi =  scannerPerenimi.next();
    System.out.println("Synniaeg yyyy-mm-dd");
    Scanner scannerSynniaeg = new Scanner(System.in);
    String synniaeg =  scannerSynniaeg.next();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    System.out.println("Isikukood:");
    Scanner scannerIsikukood = new Scanner(System.in);
    String isikokood =  scannerIsikukood.next();

    Isik isik = new Isik(eesnimi, perenimi, LocalDate.parse(synniaeg, formatter),isikokood);
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
