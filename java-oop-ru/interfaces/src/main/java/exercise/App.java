package exercise;

import java.util.List;
//import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;

// BEGIN
public class App {

    public static List<String> buildApartmentsList(List<Home> home, double n) {
        if (home.isEmpty()) {
            return new ArrayList<String>();
        }
        if (n <= 0) {
            System.out.println("Количество объектов должно быть больше 0");
            return null;
        }

        var sortedHomes = new ArrayList<Home>();
        for (int i = 0; i < n; i++) {
            sortedHomes.add(home.get(i));
        }
        Collections.sort(sortedHomes,
                (home1, home2) -> Double.compare(home1.getArea(), home2.getArea())
        );

        var result = new ArrayList<String>();
        for (var sortedHome : sortedHomes) {
            result.add(sortedHome.toString());
        }
        return result;
    }

}
// END
