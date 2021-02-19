//Binary Converter
//This code convert Binary Code to decimal number and the opposite

import java.util.Scanner;

public class BinaryConverter
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);

		System.out.println("____________________________________");
		System.out.println("__________BINARY CONVERTER__________\n");

		//Input number
		System.out.println("Insert number or binary code, then:\n- 0 for decimal to binary\n- 1 for binary to decimal\n");
		String input = tastiera.next();
		int bool = tastiera.nextInt();

		if(bool == 0)
			System.out.println("Binary Code: "+binaryCode(input));
		else
			System.out.println("Decimal Number: "+decimalNumber(input));
	}

	//Method to convert a number into binary code
	public static String binaryCode(String n)
	{
		String retValue = "";

		int num = Integer.parseInt(n);	//convert the input string into int

		while(num>0)
		{
			if(num==1)
				retValue += num;
			else
				retValue += Integer.toString(num%2);	//resto della divisione
				num = num/2;							//divide the number by 2
		}

		return new StringBuilder(retValue).reverse().toString();
	}

	//Convert binary code into a decimal number
	public static int decimalNumber(String n)
	{
		int retv = 0;

		String[] arr = n.split("");

		for(int i=arr.length-1; i>=0; i--)
		{
			retv += (Integer.parseInt(arr[i]))*Math.pow(2, i);
		}

		return retv;
	}

	/*
	//Check if the input string is binary code or a decimal number
	//Return true if it is a decimal number, false in case of a binary code
	public static boolean checkMethod(String s)
	{
		boolean ret = false;

		String[] arr = s.split("");

		for(int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
			if((arr[i]!="0") && (arr[i]!="1"))
			{
				System.out.println("AAAAAAAAAAAAAAAAAAA");
				ret = true;
			}
		}

		return ret;
	}*/
}