//Find the n number of Fibonacci Sequence

import java.util.Scanner;

public class FibonacciRecursive
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Insert number: ");
		int n = sc.nextInt();

		System.out.println(fibo(n));
	}

	private static int fibo(int num)
	{
		if(num < 2)
			return num;
		return fibo(num-2) + fibo(num-1);
	}
}

