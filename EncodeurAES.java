import javax.crypto.*;
import java.util.Base64;

public class EncodeurAES {

    /*
     * Return encode sentance by AES method
     *
     * @param s - a sentance to encode
     * @param key - word to keep secret to encode
     * */
    public static String encode(String s, SecretKey key) throws Exception {

        //Cryptage
        Cipher codeur = Cipher.getInstance("AES");
        codeur.init(Cipher.ENCRYPT_MODE, key);

        //Coder un message
        byte [] b_message = s.getBytes("UTF-8");
        byte [] b_message_code = codeur.doFinal(b_message);


        return Base64.getEncoder().encodeToString(b_message_code);
    }


    /*
     * Return deencode sentance by AES method
     *
     * @param s - a sentance to encode
     * @param key - word to keep secret to encode
     * */
    public static String decode(String s, SecretKey key) throws Exception {

        //Décriptage
        Cipher decodeur = Cipher.getInstance("AES");
        decodeur.init(Cipher.DECRYPT_MODE, key);

        //Décoder un message
        byte [] b_message_code = Base64.getDecoder().decode(s);
        byte [] b_message = decodeur.doFinal(b_message_code);


        return new String (b_message,"UTF8");
    }
}
