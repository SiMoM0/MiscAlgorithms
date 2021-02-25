#Alphabet Encrypter
#encrypte a plain text in the cipher text with a new alphabet

def encrypte(text, sAlpha, nAlpha):

    if sAlpha == "0":
        sAlpha = "abcdefghijklmnopqrstuvwxyz"
    
    if nAlpha == "0":
        nAlpha = "abcdefghijklmnopqrstuvwxyz"

    retText = ""

    for i in range(len(text)):
        retText += nAlpha[sAlpha.index(text[i])]
    return retText

plaintext = input("Plaintext: ")
startAplha = input("Start alphabet (0 for original): ")
newAplha = input("New alphabet (0 for original): ")

print("Ciphertext: ", encrypte(plaintext, startAplha, newAplha))