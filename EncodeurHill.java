public class EncodeurHill {

    /*
     * Return encode sentance by Hill method
     *
     * @param s - a sentance to encode or decode
     * @param key - matrix to encode or inverse matrix to decode
     * */
    public static String code(String s, int key[][]) {
        String e = "";
        int defaultChar = 'X' - 'A';


        // int currentMatriceLigne = 0;
        int n = key.length;
        int pos = -1;
        int nColumn = key.length;
        int nLine = key[0].length;
        int letterCode[] = new int[n];

        while (true) { // tant qu'on peux parcourir la chaine

            try {
                s.charAt(pos + 1);
            } catch (Exception except) {
                break;
            }


            for (int column = 0; column < n; column++) {
                pos++;
                for (int line = 0; line < n; line++) {
                    try {
                        letterCode[line] += key[line][column] * (s.charAt(pos) - 'A'); //calcul du codage
                    } catch (Exception except) {//Quand on la lettre n'existe pas
                        letterCode[line] += key[line][column] * defaultChar; //calcul du codage avec une lettre par default
                    }

                    letterCode[line] = letterCode[line] % 26;
                }


            }

            //enregistrement pour matrice 2*2
            e += (char) (letterCode[0] + 'A');
            e += (char) (letterCode[1] + 'A');
            letterCode = new int[n];

        }


        return e;
    }


}