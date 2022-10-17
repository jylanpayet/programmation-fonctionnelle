import java.util.*;

public class  Noeud<T extends Sommable<T> & Comparable<T>> implements Arbre<T> {
    private final List<Arbre<T>> n;

    public Noeud(List<Arbre<T>> n) {
        this.n = n;
    }

    @Override
    public int taille() {
        return this.n.stream().map(Arbre::taille).reduce(0, Integer::sum);
    }

    @Override
    public boolean contient(T val) {
        for (Arbre<T> a : n) {
            if (a.contient(val))
                return true;
        }
        return false;
    }

    @Override
    public Set<T> valeurs() {
        Set<T> res = new HashSet<>();
        for (Arbre<T> a : n) {
            res.addAll(a.valeurs());
        }
        return res;
    }

    @Override
    public T somme() {
        T first = n.get(0).somme();
        for(int i=1;i<n.size();i++){
            first = first.sommer(n.get(i).somme());
        }
        return first;
    }

    @Override
    public T min() {
        T mini = n.get(0).min();
        T var;
        for(int i=1;i<n.size();i++){
            var = n.get(i).min();
            if(mini.compareTo(var) > 0)
                mini=var;
        }
        return mini;
    }

    @Override
    public T max() {
        T maxi = n.get(0).max();
        T var;
        for(int i=1;i<n.size();i++){
            var =  n.get(i).max();
            if(maxi.compareTo(var) < 0)
                maxi=var;
        }
        return maxi;
    }

    @Override
    public boolean estTrie() {
        for(int i=0;i<n.size()-1;i++){
            if(n.get(i).max().compareTo(n.get(i+1).min())>0)
                return false;
        }
        for (Arbre<T> tArbre : n) {
            if (!tArbre.estTrie())
                return false;
        }
        return true;
    }
}