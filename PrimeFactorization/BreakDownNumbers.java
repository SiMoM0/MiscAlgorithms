//This algorithm breaks down a given number into its primes.

import java.util.Scanner;

public class BreakDownNumbers
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);

		System.out.print("Insert number: ");
		int num = tastiera.nextInt();

		System.out.print("Prime numbers: ");

		int i = 2;

		while(num!=1)
		{
			if(num%i==0)
			{
				System.out.print(i +" ");
				num = num/i;
				i = 2;
			}
			else
				i++;
		}

		System.out.println();
	}
}