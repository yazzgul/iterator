import java.util.Iterator;
public class Gener {
    public static void main(String[] args) {
        CoolLinkedList<String> str = new CoolLinkedList<>();
        str.add("Berlin");
        str.add("Moscow");
        str.add("Kazan");
//        System.out.println(str.get(0));
        Iterator<String> iterator = str.iterator();
        for (String city : str) {
            System.out.println(city);
        }
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());

    }
}


//            }
//        }