import java.util.ArrayList;
import java.util.List;

public class Spordivahendid {
    private static List<Spordivahend> spordivahendList = null;

    public Spordivahendid() {
        if (spordivahendList == null) {
            spordivahendList = new ArrayList<>();
        }
    }

    public static List<Spordivahend> getSpordivahendList() {
        return spordivahendList;
    }
}
