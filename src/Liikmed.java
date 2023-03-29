import java.util.ArrayList;
import java.util.List;

public class Liikmed {
  private List<Isik> liikmed = new ArrayList<>();

  public Liikmed() {
  }

  private boolean onLiige(Isik isik) {
    for (Isik i : liikmed) {
      if (isik.equals(i)) {
        return true;
      }
    }
    return false;
  }

  public void lisaLiikmeks(Isik isik) {
    if (onLiige(isik)) {
      liikmed.add(isik);
    }
  }

  public Isik otsiIsikEesnimega(String isikEesnimi) {
    for (Isik isik : liikmed) {
      if (isik.getEesnimi().equalsIgnoreCase(isikEesnimi)) {
        return isik;
      }
    }
    return null;
  }

  public void kuvaLiikmed() {
    for (int i = 0; i < liikmed.size(); i++) {
      System.out.println(i + 1 + ". liige on: " + liikmed.get(i));
    }
  }

  public boolean onLiikmeid() {
    return !liikmed.isEmpty();
  }

  public Isik otsiIsikNumbriJargi(int number) {
    if (number < 0 || number - 1 > liikmed.size()) {
      return null;
    }
    return liikmed.get(number - 1);
  }
}
