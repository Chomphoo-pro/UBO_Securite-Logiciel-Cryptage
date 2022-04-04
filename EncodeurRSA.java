import javax.crypto.*;
import java.security.*;
import java.util.Base64;

public class EncodeurRSA {

    /*
     * Return encode sentance by RSA method
     *
     * @param s - a sentance to encode
     * @param key - public key to encode
     * */
    public static String encode(String s, PublicKey key) throws Exception{

        //Cryptage
        Cipher codeur = Cipher.getInstance("RSA");
        codeur.init(Cipher.ENCRYPT_MODE, key);

        //Coder un message
        byte [] b_message = s.getBytes("UTF-8");
        byte [] b_message_code = codeur.doFinal(b_message);


        return Base64.getEncoder().encodeToString(b_message_code);
    }


    /*
     * Return deencode sentance by RSA method
     *
     * @param s - a sentance to encode
     * @param key - private key to encode
     * */
    public static String decode(String s, PrivateKey key) throws Exception{

        //Décriptage
        Cipher decodeur = Cipher.getInstance("RSA");
        decodeur.init(Cipher.DECRYPT_MODE, key);

        //Décoder un message
        byte [] b_message_code = Base64.getDecoder().decode(s);
        byte [] b_message = decodeur.doFinal(b_message_code);


        return new String (b_message, "UTF8");
    }


}
