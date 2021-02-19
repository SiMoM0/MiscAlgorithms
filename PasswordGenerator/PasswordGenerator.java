//Password Generator
//Program that generate a strong random password, ready for the use

import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);

		System.out.println("_______                    _________");
		System.out.println("_______ PASSWORD GENERATOR _________\n");

		System.out.println("Password: "+generatePass());
		System.out.println("____________________________________\n____________________________________");
	}

	public static String generatePass()
	{
		String[] arr0 = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
		String[] arr1 = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"};
		String[] arr2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		String[] arr3 = {"!", "£", "$", "%", "&", "@", "#"};

		Random rand = new Random();

		//Password, return value
		String password = "";

		//choose the password length (from 0 to 11)
		int lenght = rand.nextInt(11);

		//Cycle for the password creation (to length+10 so the real length will be 0+10 to 10+10)
		for(int i=0; i<lenght+10; i++)
		{
			String newChar = "";

			int num = rand.nextInt(1000);	//generate a number between 0 and 999 to choose the array
			int randChar = rand.nextInt(1000);	//generate a random number for the future choice of thr single character
			
			//choice of the array
			switch(num%4){
				case 0:
					newChar = arr0[randChar%(arr0.length)];
					break;
				case 1:
					newChar = arr1[randChar%(arr1.length)];
					break;
				case 2:
					newChar = arr2[randChar%(arr2.length)];
					break;
				case 3:
					newChar = arr3[randChar%(arr3.length)];
					break;
			}

			password += newChar;	//add the new character to the password
		}

		return password;
	}
}