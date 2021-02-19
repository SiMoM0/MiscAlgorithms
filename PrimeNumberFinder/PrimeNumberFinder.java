//Programma che verifica se un numero è primo oppure no

import java.util.Scanner;

public class PrimeNumberFinder
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);

		System.out.print("Insert number: ");
		int n = tastiera.nextInt();

		if(isPrime(n))
			System.out.println(n+" is a prime number");
		else
			System.out.println(n+" is not a prime number");
	}

	public static boolean isPrime(int num) //divide il numero per tutti i suoi precedenti e verifica se è divisibile per uno di essi
	{
		boolean value = true;
		int i = num-1;

		while(i>1) //esegue finchè non arriva a 1
		{
			if(num%i == 0) //controlla se il numero è divisibile per un suo precedente
			{
				value = false; // se è divisibile restituisce false poichè non è primo
				break;
			}
			else
				i--;
		}

		return value;
	}

}