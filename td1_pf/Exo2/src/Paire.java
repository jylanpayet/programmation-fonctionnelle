public class Paire<U,V> implements Iaire<U,V> {
    U u;
    V v;
    Paire(U u, V v) {
        this.u=u;
        this.v=v;
    }

    @Override
    public U fst() {
        return u;
    }

    @Override
    public V snd() {
        return v;
    }

    @Override
    public <X> Iaire<X,V> changeFst(X x) {
        return new Paire<>(x,this.v);
    }

    @Override
    public <X> Iaire<U,X> changeSnd(X x) {
        return new Paire<>(this.u,x);
    }

    @Override
    public String toString() {
        return "Paire(" + u +
                ", " + v +
                ") :: Paire["+u.getClass().getSimpleName()+','+v.getClass().getSimpleName()+"]";
    }
}
