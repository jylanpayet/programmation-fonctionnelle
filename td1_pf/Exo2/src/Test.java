public class Test {

    public static void main(String[]args){
        Paire<Integer,String> t= new Paire<>(1,"un");
        System.out.println(t.toString());
        System.out.println(t.changeFst(1.0).toString());
        System.out.println(t.changeFst(1.0).changeSnd(t).toString());
    }
}
