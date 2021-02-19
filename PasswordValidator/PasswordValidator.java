/*
Program Password Validator with the following rules:
	length between 5 and 20
	at least a number
	at least a special character
	no spaces
*/

import java.util.Scanner;

public class PasswordValidator
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Insert a password: ");
		String psw = tastiera.nextLine();

		int length = psw.length();

		boolean value1 = false; // value for final validator
		boolean value2 = false;
		boolean value3 = false;
		boolean value4 = true;

		if(length >= 5 && length <=20) //controls the length of psw
			value1 = true;

		String[] arr = new String[length]; //array which contains the characters of psw
		for(int i=0; i<arr.length; i++)
			arr[i] = psw.substring(i, i+1);

		//controls if a number is in
		for(int j=0; j<arr.length; j++)
		{
			if(validateNumber(arr[j]))
				value2 = true;
		}

		//controls if there are special characters
		for(int k=0; k<arr.length; k++)
		{
			if(validateChar(arr[k]))
				value3 = true;
		}

		//controls if there are spaces
		for(int h=0; h<arr.length; h++)
		{
			if(arr[h].equals(" "))
				value4 = false;
		}

		if(value1 && value2 && value3 && value4)
		{
			System.out.println("Valid password");
		}
		else 
			System.out.println("Not valid password");

	}	

	public static boolean validateNumber(String a)
	{
		String[] numArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

		boolean val = false;

		for(int i=0; i<numArr.length; i++)
		{
			if(a.equals(numArr[i]))
			{
				val = true;
				break;
			}
			val = false;
		}

		return val;
	}

	public static boolean validateChar(String b)
	{
		String[] chaArr = {"!", "£", "$", "%", "&", "@", "#", "?"};

		boolean valu = false;

		for(int i=0; i<chaArr.length; i++)
		{
			if(b.equals(chaArr[i]))
			{
				valu = true;
				break;
			}
			valu = false;
		}

		return valu;
	}
}