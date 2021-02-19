//Programma che genera una lista di tutti i primi 'n' numeri primi
//
//Programma che genera tutti i numeri da 1 a n numero inserito e lo divide per tutti i numeri precedenti verificando se genera un resto di 0. 

import java.util.Scanner;

public class PrimeNumbers
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);

		System.out.print("Insert a number: ");
		int n = tastiera.nextInt();

		int i = 0; // conta il numero di numeri primi genreati
		int j = 2; //genera tutti i numeri da 2 a n numero inserito

		System.out.print("1 ");
		
		while(i<n-1)
		{
			if(isPrime(j)) //controlla se il numero è primo
			{
				System.out.print(j+" "); //stampa il numero primo
				i++; //incrementa il contatore di numeri primi trovati
			}
			j++; //incrementa di 1 i numeri generati
		}

		System.out.println();
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