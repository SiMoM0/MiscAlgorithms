//Break Caesar Cipher
//A brute force approach to list all the possible decrypted messages from the input text.

import java.util.Scanner;

public class BreakCaesarCipher
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);

		System.out.println(" ----------------------------------------------- ");
		System.out.println("|              BREAK CAESAR CIPHER              |");
		System.out.println(" ----------------------------------------------- \n");

		System.out.print("Ciphertext: ");
		String text = tastiera.nextLine();	//text to decrypt

		System.out.println("");

		for(int i=1; i<26; i++)
		{
			System.out.println("Key "+i+", Plaintext: "+crypto(text, i));
		}

	}


	//Decrypte method
	public static String crypto(String s, int n)
	{
		String ret = "";	//return value

		for(int i=0; i<s.length(); i++)
			ret += getChar(s.charAt(i), Math.abs(26-n));	//substitute every single character

		return ret;
	}

	//Get the new character after the shift
	public static String getChar(char s, int n)
	{
		String values = "abcdefghijklmnopqrstuvwxyz";				//string model
		String[] arrVal = values.split("");							//conversion into array

		int position = 0;											//starting position

		for(int i=0; i<arrVal.length; i++)
		{
			if(arrVal[i].equals(Character.toString(s)))				//find the actual character and return position
			{
				position = i;
			}
		}

		int newPos = position+n;

		return arrVal[newPos%arrVal.length];						//return new character
	}
}