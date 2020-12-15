//TRADUTTORE DA TESTO A CODICE BINARIO
//Formato di input, esempio: ciaodwanves
//File .txt da cui importare i valori: binary_text.txt

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BinaryTranslator2
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		Dictionary2 table = new Dictionary2();
		table.fillDictionary();

		System.out.println("******Binary Translator(from text to binary code)******");
		String sTesto = keyboard.nextLine();
		String[] arrTesto = sTesto.split("");

		System.out.print("Binary Code:");
		for(int i=0; i<arrTesto.length; i++)
			System.out.print(" "+table.searchBin(arrTesto[i]));
		System.out.println("");
	}
}

//DIZIONARIO con coppie (carattere ascii, codice binario)
class Dictionary2
{
	Pair[] pair = new Pair[27];		//array contenente le coppie
	int index = 0;					//indice per il riempimento dell'array

	//Metodo che restituisce il codice binario, in base al testo inserito
	public String searchBin(String s)
	{
		String retValue = "";
		for(int i=0; i<pair.length; i++)		//semplice ricerca lineare
		{
			if(pair[i].getText().equals(s))
				retValue = pair[i].getBin(); 	//restituzione del codice binario
		}
		return retValue;
	}

	//Metodo per l'inserimento delle coppie (carattere, codice binario)
	private void insertPairs(Pair p)
	{
		pair[index] = p;
		index++;
	}

	//metodo per riempire il dizionario con le coppie (carattere, binario) dalle informazioni contenute nel file di testo
	public void fillDictionary() throws FileNotFoundException
	{
		insertPairs(new Pair(" ", "00100000"));	//inserimento manuale dello spazio
		
		FileReader fr = new FileReader("binary_text.txt");	//lettura file di testo
		BufferedReader bf = new BufferedReader(fr);
		String st = "";
		
		try
		{
			while((st = bf.readLine())!= null)
			{
				Scanner tk = new Scanner(st);			//Scanner token
				String ascii = tk.next();				//carattere
				String zerouno = tk.next();				//codice binario
				insertPairs(new Pair(ascii, zerouno));	//inserimento nel dizionario
			}
		} catch(IOException ioe) {}
	}

	//CLASSE che realizza le coppie (carattere, codice binario)
	private class Pair
	{
		String text;	//carattere
		String bin;		//codice binario

		private Pair(String sText, String sBin)
		{
			text = sText;
			bin = sBin;
		}
	
		private String getText() { return text;}
		private String getBin() { return bin;}
	}
}