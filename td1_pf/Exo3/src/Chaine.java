public class Chaine implements Sommable<Chaine>, Comparable<Chaine> {
    private final String valeur;

    public Chaine(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public Chaine sommer(final Chaine valeur) {
        return new Chaine(this.valeur + valeur.getValeur());
    }

    public String getValeur() { return this.valeur; }

    @Override
    public String toString() {
        return "Chaine{" +
                "valeur='" + valeur + '\'' +
                '}';
    }

    @Override
    public int compareTo(Chaine autre) {
        return this.valeur.compareTo(autre.getValeur());
    }
}
