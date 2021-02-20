//Easy encrypter program
//Insert a message and a number (the shift), the output will be the message with all the characters sfithed

import java.util.Scanner;

public class ShiftEncrypter
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);

		System.out.println("___________________________________");
		System.out.println("__________SHIFT ENCRYPTER__________\n");

		System.out.print("Message: ");
		String msg = tastiera.nextLine();	//input message

		System.out.print("Shift: ");
		int shift = tastiera.nextInt();		//input shift

		System.out.println("Encrypted Message: "+encrypt(msg, shift));	//output
		System.out.println("Decrypted Message: "+decrypt(msg, shift));	//output

	}

	//Encrypt method
	public static String encrypt(String s, int n)
	{
		String ret = "";

		for(int i=0; i<s.length(); i++)
		{
			ret = ret + getChar(s.charAt(i), n);	//change every single character
		}

		return ret;

	}

	//Decrypt method
	public static String decrypt(String s, int n)
	{
		String ret = "";

		for(int i=0; i<s.length(); i++)
		{
			ret = ret + getChar(s.charAt(i), Math.abs(37-n));	//change every single character (37 is the length of values string)
		}

		return ret;

	}

	//Get the new character after the shift
	public static String getChar(char s, int n)
	{
		String values = "abcdefghijklmnopkrstuvwxyz1234567890 ";	//string model
		String[] arrVal = values.split("");							//conversion into array

		int position = 0;	//starting position

		for(int i=0; i<arrVal.length; i++)
		{
			if(arrVal[i].equals(Character.toString(s)))	//find the actual character and return position
			{
				position = i;
			}
		}

		int newPos = position+n;

		return arrVal[newPos%arrVal.length];	//return new character
	}
}