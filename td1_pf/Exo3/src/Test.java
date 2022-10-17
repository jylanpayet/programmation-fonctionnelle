import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[]args){
        Chaine a=new Chaine("a");
        Chaine b=new Chaine("b");
        Chaine c=new Chaine("c");
        Chaine d=new Chaine("d");
        Chaine e=new Chaine("c");

        Arbre<Chaine> fa = new Feuille<>(a);
        Arbre<Chaine> fb = new Feuille<>(b);
        Arbre<Chaine> fc = new Feuille<>(c);
        Arbre<Chaine> fd = new Feuille<>(d);
        Arbre<Chaine> fe = new Feuille<>(e);

        List<Arbre<Chaine>> l = new ArrayList<>();
        List<Arbre<Chaine>> li = new ArrayList<>();
        li.add(fd);
        li.add(fe);
        Arbre<Chaine> fu=new Noeud<>(li);

        l.add(fa);
        l.add(fb);
        l.add(fc);
        l.add(fu);

        Arbre<Chaine> fn=new Noeud<>(l);
        System.out.println(fn.estTrie());
        System.out.println(fn.somme());
        System.out.println(fn.taille());
        System.out.println(fn.min());
        System.out.println(fn.max());
    }
}
