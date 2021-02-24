#Convert binary code to hexadecimal

table = {"0000": "0", "0001": "1", "0010": "2", "0011": "3", "0100": "4", "0101": "5", "0110": "6", "0111": "7", "1000": "8", "1001": "9", "1010": "A", "1011": "B", "1100": "C", "1101": "D", "1110": "E", "1111": "F"}

#function to convert gruop of 4 bits to the corrispondent hexadecimal character
def convertHex(code):
    code = code.replace(" ", "")
    #format string to be a multiple of 4
    while len(code)%4 != 0:
        code = "0" + code
    
    hexa = ""   #return string

    for i in range(len(code)//4):
        hexa +=  table.get(code[i*4:i*4+4])

    return hexa


#function to convert binary code into decimal
def convertDec(code):
    j = len(code)-1
    decimal = 0

    for i in range(len(code)):
        decimal += int(code[i]) * 2**j
        j -= 1

    return decimal

code = input("Binary Code: ")

print("Hexadecimal Code: ", convertHex(code))
print("Decimal: ", convertDec(code))