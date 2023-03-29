import java.util.ArrayList;
import java.util.List;

public class Liikmed {
  private static List<Isik> liikmed = null;

  public Liikmed() {
    if (liikmed == null) {
      liikmed = new ArrayList<>();
    }
  }

  public void setLiikmed(List<Isik> liikmed) {
    this.liikmed = liikmed;
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
    if(onLiige(isik)) {
      liikmed.add(isik);
    }
  }

  public static List<Isik> getLiikmed() {
    return liikmed;
  }
}
