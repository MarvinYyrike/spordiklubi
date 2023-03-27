import java.util.ArrayList;
import java.util.List;

//Antud klass talletab kõik spordivahendid, mis on olemas spordiklubi inventaaris
public class Spordivahendid {
    private List<Spordivahend> spordivahendList;

    public Spordivahendid() {
        if(spordivahendList.isEmpty()) {
            this.spordivahendList = new ArrayList<>();
        }
    }

    public List<Spordivahend> getSpordivahendList() {
        return spordivahendList;
    }
}
