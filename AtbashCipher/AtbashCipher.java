//Atbash Cipher
//Implementation of the Atbash Cipher, which works by taking the alphabet and mapping it to its reverse
//Plain alphabet: 	ABCDEFGHILMNOPQRSTUVZ
//Cipher alphabet: 	ZVUTSRQPONMLIHGFEDCBA

import java.util.Scanner;

public class AtbashCipher
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);

		System.out.println(" ----------------------------------------- ");
		System.out.println("|              ATBASH CIPHER              |");
		System.out.println(" ----------------------------------------- \n");

		System.out.print("Plaintext: ");
		String text = tastiera.nextLine();	//text to encrypt

		System.out.println("");

		System.out.println("Ciphertext: "+crypto(text));

	}


	//Encrypt method
	public static String crypto(String s)
	{
		String ret = "";	//return value

		for(int i=0; i<s.length(); i++)
			ret += getChar(s.charAt(i));	//substitute every single character

		return ret;
	}

	//Get the new character after the shift
	public static String getChar(char c)
	{
		String plain = "abcdefghilmnopqrstuvz";						//original alphabet
						
		String[] arrPlain = plain.split("");							//conversion into array

		String newAlpha = "zvutsrqponmlihgfedcba";

		String[] arrNew = newAlpha.split("");


		int position = 0;											//starting position

		for(int i=0; i<arrPlain.length; i++)
		{
			if(arrPlain[i].equals(Character.toString(c)))				//find the actual character and return position
			{
				position = i;
			}
		}

		return arrNew[position];						//return new character
	}
}