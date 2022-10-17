import java.util.*;

public class  Noeud<T extends Sommable<T> & Comparable<T>> implements Arbre<T> {
    private List<Arbre<T>> n;

    public Noeud(List<Arbre<T>> n) {
        this.n = new ArrayList<>();
    }

    @Override
    public int taille() {
        return this.n.stream().map(Arbre::taille).reduce(0, Integer::sum);
    }

    @Override
    public boolean contient(T val) {
        for ( Arbre<T> a : n) {
            if (a.contient(val))
                return true;
        }
        return false;
    }

    @Override
    public Set<T> valeurs() {
        Set<T> res = new HashSet<>();
        for ( Arbre<T> a : n) {
            res.addAll(a.valeurs());
        }
        return res;
    }

    @Override
    public T somme() {
        Iterator<Arbre<T>> first = n.iterator();
        T next = first.next().somme();
        T tmp;
        while (first.hasNext()) {
            tmp = first.next().somme();
            next = next.sommer(tmp);
        }
        return next;
    }

    @Override
    public T min() {
        T mini = n.get(0).min();
        for(Arbre <T> a : n){
            T var = a.min();
            if(mini.compareTo(var) >0)
                mini=var;
        }
        return mini;
    }

    @Override
    public T max() {
        T maxi = n.get(0).max();
        for(Arbre <T> a : n){
            T var = a.max();
            if(maxi.compareTo(var) < 0)
                maxi=var;
        }
        return maxi;
    }

    @Override
    public boolean estTrie() {
        return trie1() && trie2();
    }

    private boolean trie1() {
        for (int i = 0; i < n.size() - 1; i++) {
            if (!n.get(i).estTrie())
                return false;
        }
        return true;
    }

    private boolean trie2() {
        for( int i = 0; i < n.size() - 1; i++){
            if(n.get(i).max().compareTo(n.get(i+1).min())>0){
                return false;
            }
        }
        return true;
    }
}

