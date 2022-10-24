import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static <T> List<T> filtragePredicatif(List<Predicate<T>> conditions, List<T> elements){
        List<T> r = new ArrayList<>();
        Predicate<T> predicat = x -> true;
        for(Predicate<T> p : conditions)
            predicat = predicat.and(p);
        for(T e : elements) {
            if (predicat.test(e))
                r.add(e);
        }
        return r;
    }

    public static void main(String[] args) {

        Predicate<Paire<Integer, Double>> tropPetite = p -> p.fst < 100;
        Predicate<Paire<Integer, Double>> tropGrande = p -> p.fst > 200;
        Predicate<Paire<Integer, Double>> tailleIncorrecte = p -> tropPetite.test(p) || tropGrande.test(p);
        Predicate<Paire<Integer, Double>> tailleCorrecte = Predicate.not(tailleIncorrecte);
        Predicate<Paire<Integer, Double>> tropLourd = p -> p.snd > 150.0;
        Predicate<Paire<Integer, Double>> poidsCorrect = Predicate.not(tropLourd);
        Predicate<Paire<Integer, Double>> accesAutorise = p -> poidsCorrect.test(p) && tailleCorrecte.test(p);

        Paire<Integer, Double> test1 = new Paire<>(150, 100.0);
        Paire<Integer, Double> test2 = new Paire<>(250, 100.0);
        Paire<Integer, Double> test3 = new Paire<>(150, 200.0);

        List<Predicate<Paire<Integer, Double>>> p= new ArrayList<>();
        p.add(tailleCorrecte);
        p.add(poidsCorrect);

        List<Paire<Integer,Double>> l= new ArrayList<>();
        l.add(test1);
        l.add(test2);
        l.add(test3);


        System.out.println(filtragePredicatif(p,l));


    }
}
