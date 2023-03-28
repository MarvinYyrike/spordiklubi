public class Main {
    public static void main(String[] args) {
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
    }
