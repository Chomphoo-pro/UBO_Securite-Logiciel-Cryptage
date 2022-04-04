import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class mainRSA {
    public static void main (String[] args) throws Exception {
        //Generate public key & private key
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        KeyPair rsa = generator.generateKeyPair();


        String s = "Bonjour tout l'monde.";
        System.out.println("Original: ");
        System.out.println(s);

        System.out.println("");

        String sc = EncodeurRSA.encode(s, rsa.getPublic());
        System.out.println("code: ");
        System.out.println(sc);

        System.out.println("");

        String sd = EncodeurRSA.decode(sc, rsa.getPrivate());
        System.out.println("decode: ");
        System.out.println(sd);


    }
}
