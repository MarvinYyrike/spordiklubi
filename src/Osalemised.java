import java.util.ArrayList;
import java.util.List;

public class Osalemised {
  private List<Osalemine> osalemineList = new ArrayList<>();

  public Osalemised() {}

  public void lisaOsalemine(Isik isik, Yritus yritus) {
    Osalemine osalemine = new Osalemine(isik, yritus);
    for (Osalemine o : osalemineList) {
      if (osalemine.equals(o)) {
        return;
      }
    }
    osalemineList.add(osalemine);
  }


}
