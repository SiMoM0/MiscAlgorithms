//CAESAR CIPHER
//Every character is shifted by given number of position on the left or right
//Insert a positive integer key for a right shift, a negative integer for a left shift

import java.util.Scanner;

public class CaesarCipher
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);

		System.out.println("_________________________________");
		System.out.println("__________CAESAR CIPHER__________\n");

		System.out.print("Plaintext: ");
		String text = tastiera.nextLine();	//text to encrypt

		System.out.print("Key: ");
		int key = tastiera.nextInt();	//value of key

		System.out.println("");

		System.out.println("Ciphertext: "+crypto(text.toLowerCase(), key));
	}

	//Encrypte method
	public static String crypto(String s, int n)
	{
		String ret = "";	//return value

		for(int i=0; i<s.length(); i++)
			ret += getChar(s.charAt(i), Math.abs(26+n));	//substitute every single character

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