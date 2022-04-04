public class EncodeurVigenere {

    /*
    * Return encode sentance by Vigenere method
    *
    * @param s - a sentance to encode
    * @param key - word to keep secret to encode
    * */
    public static String encode(String s, String key) {
        String e = "";

        for (int i = 0 ; i < s.length() ; i++){
            int nbCScret = key.length();
            int cs = s.charAt(i)-'A';
            int cSecret = key.charAt(i%nbCScret)-'A';

            //if character of sentance is not a letter
            if (!Character.isLetter(s.charAt(i))){
                e += s.charAt(i); //add this charactere to result
            } else {
                //get addition ascii in letter
                char c = (char) ((cSecret+cs)%26+'A');
                e += c;
            }


        }

        return e;
    }


    /*
     * Return deencode sentance by Vigenere method
     *
     * @param s - a sentance encoded to decode
     * @param key - word use for encoded to decode
     * */
    public static String decode(String s, String key){
        String e = "";

        for (int i = 0 ; i < s.length() ; i++){
            int nbCScret = key.length();
            int cs = s.charAt(i)-'A';
            int cSecret = key.charAt(i%nbCScret)-'A';

            //if character of sentance is not a letter
            if (!Character.isLetter(s.charAt(i))){
                e += s.charAt(i); //add this charactere to result
            } else {
                //get difference ascii in letter
                char c = (char) (((cs-cSecret)+26)%26+'A');
                e += c;
            }
        }

        return e;
    }
}
