import java.util.Scanner;

public class ScomposizioneNumeri
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);

		System.out.print("Insert number: ");
		long num = tastiera.nextInt();

		Prime list = new Prime();
		int i=2;

		while(num!=1)
		{
			if(num%i == 0)
			{
				list.addPrime(i);
				num = num/i;
				i = 2;
				System.out.println(num);
			}
			else
			{
				i++;
			}	
		}

		System.out.println("\nList of prime numbers: ");

		list.stampa();

	}
}

class Prime
{	
	Primi[] v;
	int size;

	public Prime()
	{
		v = new Primi[10];
		makeEmpty();
	}

	public void makeEmpty()
	{
		size = 0;
	}

	public boolean contains(long num) //metodo per verificare se un numero primo è già presente
	{
		for(int i=0; i<size; i++)
			if(v[i].getPrimo() == num)
				return true;
		return false;
	}

	public void addPrime(long num) //metodo per aggiungere numeri primi
	{
		if(contains(num))
		{
			for(int i=0; i<size; i++)
				if(v[i].getPrimo() == num)
					v[i].increase();
		}
		else
		{
			if(size==v.length)
			{
				Primi[] w = new Primi[2*size];
				System.arraycopy(v, 0, w, 0, size);
				v = w;
			}

			Primi nuovo = new Primi(num);
			v[size++] = nuovo;
		}
	}

	public void stampa()
	{
		for(int i=0; i<size; i++)
			System.out.println(v[i].getPrimo() +" for "+ v[i].getMuch() +" times");
	}

	class Primi
	{
		private long primo;
		private int much;

		public Primi(long p)
		{
			primo = p;
			much = 1;
		}

		public long getPrimo()
		{
			return primo;
		}

		public int getMuch()
		{
			return much;
		}

		public void increase()
		{
			much++;
		}
	}
}