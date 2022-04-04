public class mainVigenere {
    public static void main (String[] args){
        String s = "Bonjour tout l'monde.".toUpperCase();
        System.out.println("Original: ");
        System.out.println(s);

        System.out.println("");

        String sc = EncodeurVigenere.encode(s, "MUSIQUE");
        System.out.println("code: ");
        System.out.println(sc);

        System.out.println("");

        String sd = EncodeurVigenere.decode(sc, "MUSIQUE");
        System.out.println("decode: ");
        System.out.println(sd);
    }
}
