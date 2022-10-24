import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[]args) {


        // Question 1 :
        Somme<Integer> sommeEntiers = Integer::sum;
        Somme<Double> sommeDouble = Double::sum;
        Somme<Long> sommeLong = Long::sum;
        Somme<String> sommeString = String::concat;

        // Question n°2 :
        List<String> l2s = new ArrayList<>();
        l2s.add("e1");
        l2s.add("e2");

        ToString<List<String>> listToString = x -> {
            String listString = x.stream().map(Object::toString).collect(Collectors.joining(", "));
            return Collections.singletonList(listString);
        };
        System.out.println(listToString.convert(l2s));
    }
}
