import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class mainHill {
    public static void main (String[] args) throws Exception {
        //Génération de la matrice clé
        int key[][] = new int[2][2];
        key[0][0] = 3;
        key[0][1] = 4;

        key[1][0] = 5;
        key[1][1] = 9;


        //Matrice inverse
        int key_decode[][] = new int[2][2];

        key_decode[0][0] = 5;
        key_decode[0][1] = 18;

        key_decode[1][0] = 3;
        key_decode[1][1] = 19;


        String s = "Bonjour".toUpperCase();
        System.out.println("Original: ");
        System.out.println(s);

        System.out.println("");

       String sc = EncodeurHill.code(s, key);
        System.out.println("code: ");
        System.out.println(sc);

        System.out.println("");

        String sd = EncodeurHill.code(sc, key_decode);
        System.out.println("decode: ");
        System.out.println(sd);
    }
}
