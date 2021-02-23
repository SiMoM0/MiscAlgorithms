# Caesar Cipher

(EN)
In cryptography, Caesar Cipher is one of the simplest and most known encryption techniques. Each letters of the plain text is replaced by a letter
some fixed number of positions down the alphabet.

In the algorithm [Caesar Cipher](https://github.com/SiMoM0/MiscAlgorithms/blob/main/CaesarCipher/CaesarCipher.java), a positive integer number indicate a right shift of the alfabeth, while a negative integer correspond to a left shift.

To break the Cipher, use the [Break Caesar Cipher](https://github.com/SiMoM0/MiscAlgorithms/blob/main/CaesarCipher/BreakCaesarCipher.java) Java code, a brute force approach to list all the possible decrypted messages and corrispondent key, from the input text. <br/>

(ITA)
Nella crittografia, il Cifrario di Cesare è uno dei più antichi e conosciuti algoritmi crittografici. Ogni lettera del messaggio originale viene sostituita
da quella che si trova ad un certo numero di posizione successive/precedenti nell'alfabeto.

L'algoritmo [Caeser Cipher](https://github.com/SiMoM0/MiscAlgorithms/blob/main/CaesarCipher/CaesarCipher.java) esegue uno shift destro se la chiave è un numero intero positivo, shift sinistro se invece il numero inserito è negativo.

Per rompere la cifratura, utilizzare il codice Java [Break Caesar Cipher](https://github.com/SiMoM0/MiscAlgorithms/blob/main/CaesarCipher/BreakCaesarCipher.java), un approccio brute force che elenca ogni possibile messaggio decifrato con la corrispondente chiave di cifratura.

<br/>

#### Example:

Plaintext: abcdefgh

Key: 4

Ciphertext: efghijkl
