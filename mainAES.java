import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class mainAES {
    public static void main (String[] args) throws Exception {
        //Génération d'une clé
        byte [] decodedKey = Base64.getDecoder().decode("secret");
        SecretKey key = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");

        String s = "Bonjour tout l'monde.";
        System.out.println("Original: ");
        System.out.println(s);

        System.out.println("");

        String sc = EncodeurAES.encode(s,key);
        System.out.println("code: ");
        System.out.println(sc);

        System.out.println("");

        String sd = EncodeurAES.decode(sc, key);
        System.out.println("decode: ");
        System.out.println(sd);
    }
}
