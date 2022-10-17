public interface Iaire <U, V>{
    U fst();
    V snd();
    <X> Iaire <X,V> changeFst(X x);
    <X> Iaire <U,X> changeSnd(X x);
}
