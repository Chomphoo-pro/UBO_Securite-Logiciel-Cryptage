
  

# Algorithms de cryptage


## VIGENERE

*Vigenère est un chiffrement symétrique utilisant l'alphabet pour chiffrer et déchiffrer des messages.
-Un tableau N * N est utilisé avec un décalage de lettres.
-Nous restons ici dans l'alphabet [az-AZ].*

**Pour chiffrer** HARICOTS avec le mot clé MANGER. Nous prenons la:
- Première lettre de haricots(H) et de manger(M) et nous regardons le croisement de ces deux lettres dans le tableau. Donc cela donne la lettre T.
![enter image description here](https://pages.mtu.edu/~shene/NSF-4/Tutorial/VIG/FIG-VIG-Table-EX-M.jpg)

- Deuxième lettre de haricots ( A ) et de manger ( A ) qui donne A
- Troisème lettre de haricots ( R ) et de manger ( N ) qui donne E
- Ainsi de suite

Nous obtenons le chiffrement: TAEOGFFS

**Pour déchiffrer** nous prenons la première lettre du chiffrement ( T ) et MANGER ( M ) et nous regardons à quelle ligne il appartient ( H )
Ainsi de suite.
Cela donne HARICOTS.

**Utilisation des fonctions:**
*cryptage*:
Syntax:

    public static String encode(String phrase, String key)

Exemple:

    String sc = EncodeurVigenere.encode("HARICOTS", "MANGER");

*décryptage*:
Syntaxe:

    public static String decode(String phrase, String key)

Exemple:

    String sd = EncodeurVigenere.decode("HARICOTS", "MANGER");

  

## HILL
*HILL est un chiffrement symétrique utilisant les matrices de chiffre pour chiffrer et déchiffrer des messages.
-Une matrice N * N est utilisé. 
-Chaque lettre du mot à chiffrer seras groupé par N lettres et dans le cas échéant les lettres manquantes seras ici remplacé par **X**.
exemple: HARICOT
groupement(N=2): HA RI CO T**X***

**Pour chiffrer**
Nous utilisons la matrice 2 * 2 identité:
3 4
5 9

Pour chaque groupe de lettre, nous récupérons leur emplacement dans l'alphabet avec A=0.
Exemple: HA RI CO TX = (7 0) (17 8) (2 14) (19 23)

Nous multiplions cela par la matrice, ce qui donne: (21 9) (5 1) (10 6) (19 16)
Si nous remplaçons le résultat par l'emplacement d'une lettre dans l'alphabet. Nous obtenons le chiffrement: VJFBKGTQ


**Pour déchiffrer**
Il faut alors procédé exactement de la même manière avec avec en plus le calcul de la matrice inverse. Ce qui nous donne cela: 
3 18
3 19

**Utilisation des fonctions:**
*cryptage*:
Syntax:

    public static String code(String phrase, int matrice_identité[][])

Exemple:

		int matrice_identité[][] = new int[2][2];
		
        matrice_identité[0][0] = 3;
        matrice_identité[0][1] = 4;
        matrice_identité[1][0] = 5;
        matrice_identité[1][1] = 9;
        
        String phrase = "HARICOT";
        
        String sc = EncodeurHill.code(String phrase, int matrice_identité[][]);
        
 *décryptage*:
Syntax:

    public static String code(String phrase, int matrice_inverse[][])

Exemple:

		int matrice_inverse[][] = new int[2][2];
		
        matrice_inverse[0][0] = 5;
        matrice_inverse[0][1] = 18;
        matrice_inverse[1][0] = 3;
        matrice_inverse[1][1] = 19;
        
        String phrase = "VJFBKGTQ";
        
        String sd = EncodeurHill.code(String phrase, int matrice_inverse[][]);

## AES
*AES est un chiffrement symétrique utilisant une seule clé. Si L'émetteur: Alice, chiffre son message avec le mot MANGER. Alors le destinataire: Bob,  déchiffre le message avec le mot MANGER. Ce qui implique que le destinataire doit avoir connaissance du mot clé. *
  
 **Génération d'une clé:**

    byte [] decodedKey = Base64.getDecoder().decode("secret");  
    SecretKey key = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");

  **Pour chiffrer**, Alice utilisé donc le mot clé MANGER
  *cryptage*:
Syntax:

    public static String encode(String chaine, SecretKey key)

Exemple:

    String sc = EncodeurAES.encode(s,key);

   **Pour déchiffrer**, Bob utilisé donc le mot clé MANGER
    *cryptage*:
Syntax:

    public static String decode(String chaine, SecretKey key)

Exemple:

    String sd = EncodeurAES.decode(sc, key);

## RSA
*RSA est un chiffrement asymétrique utilisant un couple de clé généré par un très fort algorithme mathématique.
Nous obtenons donc :
-Une clé publique dont il est possible de la partager.
-Une clé privée que doit toujours rester avec le propriétaire de celui qui l'a généré.
En utilisant la clé privé nous signons notre message mais le message est en claire et non chiffré. La signature peut ainsi être vérifié par le destinataire qui détient la clé publique de cette personne afin de vérifier l'authenticité du message.*

**Pour chiffrer**, Alice souhaite chiffrer son message, il lui faut donc récupérer la clé publique du destinataire; Bob afin de l'utiliser pour le chiffrement. C'est à dire, chaque nouveau destinataire, une nouvelle clé publique appartenant au destinataire. 
A chaque nouvelle clé publique un nouveau message crypté. Ici, Alice souhaite juste envoyer un message chiffré à Bob. Elle auras donc besoin de seulement la clé publique de Bob pour chiffré un message que seul Bob puisse déchiffrer avec sa clé privée.
![enter image description here](https://inet-system.com/wp-content/uploads/2014/09/alice-et-bob-chiffrement-asym%C3%A9trique.png)

**Pour déchiffrer**, 
L'émettrice: Alice, à envoyé la clé chiffré par la clé publique de Bob
Le destinataire: Bob, viens de recevoir le message chiffré par sa propre clé publique. Seul la clé privé de Bob lui permet d'ouvrir le message et de le lire. Car le message est chiffré avec sa clé publique.

*génération du couple de clé:*

    KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");  
    generator.initialize(1024);  
    KeyPair rsa = generator.generateKeyPair();


*cryptage*:
Syntax:

    String s = EncodeurRSA.encode(String phrase, PublicKey cléPublic);

Exemple:

    String sc = EncodeurRSA.encode("toto", rsa.getPublic());

*décryptage*:
Syntax:
   

     String sc = EncodeurRSA.decode(String phrase_crypté, PrivateKey cléPrivé);

Exemple:

    String chaineCrypte = "TzUSaaDOPSZqV1hk2iRXEledbuWlhD/ZzQMlV5K3dYjaK7Q+yKt09tD5/9m3eNWgNtWsszOPHA+7lmdX/j2RXctIXPgoih1UvEmh+aRyaTGHiCtAwYzZMhUxXltl41TWJ/qzZ0SLCnoAinzgpTI3jT5BhaPEJW0X+WfXhDjmMSI=";
    String sd = EncodeurRSA.decode(chaineCrypte, rsa.getPrivate());


