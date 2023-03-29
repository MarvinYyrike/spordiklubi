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
    if(onLiige(isik)) {
      liikmed.add(isik);
    }
  }

  public List<Isik> getLiikmed() {
    return liikmed;
  }
}
