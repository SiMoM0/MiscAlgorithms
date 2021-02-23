//ROT 13
//Every character is shifted by 13 position on the right
//The algorithms is a special case of Caesar Cipher

import java.util.Scanner;

public class ROT13
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);

		System.out.println("__________________________");
		System.out.println("__________ROT 13__________\n");

		System.out.print("Plaintext: ");
		String text = tastiera.nextLine();	//text to encrypt

		System.out.println("");

		System.out.println("Ciphertext: "+crypto(text.toLowerCase()));
	}

	//Encrypte method
	public static String crypto(String s)
	{
		String ret = "";	//return value

		for(int i=0; i<s.length(); i++)
			ret += getChar(s.charAt(i));	//substitute every single character

		return ret;
	}

	//Get the new character after the shift by 13 positions
	public static String getChar(char c)
	{
		String values = "abcdefghijklmnopqrstuvwxyz";				//string model
		String[] arrVal = values.split("");							//conversion into array

		int position = 0;											//starting position

		for(int i=0; i<arrVal.length; i++)
		{
			if(arrVal[i].equals(Character.toString(c)))				//find the actual character and return position
			{
				position = i;
			}
		}

		return arrVal[(position+13)%arrVal.length];										//return new character
	}
}