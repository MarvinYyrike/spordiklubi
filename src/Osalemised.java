import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Osalemised {
  private List<Osalemine> osalemineList = new ArrayList<>();

  public Osalemised() {
  }

  public Osalemine lisaOsalemine(Isik isik, Yritus yritus) {
    Osalemine osalemine = new Osalemine(isik, yritus);
    for (Osalemine o : osalemineList) {
      if (osalemine.equals(o)) {
        return o;
      }
    }
    osalemineList.add(osalemine);
    return osalemine;
  }

  public List<Isik> tulemusteArvutamine(Yritus yritus) {
    List<Isik> voistlejad = new ArrayList<>();
    for (Osalemine osalemine : osalemineList) {
      if (osalemine.getYritus().equals(yritus)) {
        voistlejad.add(osalemine.getIsik());
      }
    }

    Random random = new Random();
    List<Isik> tulemused = new ArrayList<>(voistlejad.size());
    while (!voistlejad.isEmpty()) {
      int lopetajaIndeks = random.nextInt(0, voistlejad.size());
      tulemused.add(voistlejad.remove(lopetajaIndeks));
    }
    return tulemused;
  }
}
