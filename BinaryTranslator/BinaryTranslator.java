//TRADUTTORE DA CODICE BINARIO A TESTO
//Formato di input, esempio: 10101010 01001011 01011100 01101000
//File .txt da cui importare i valori: binary_text.txt

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BinaryTranslator
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		Dictionary table = new Dictionary();
		table.fillDictionary();

		System.out.println("******Binary Translator******");
		String sCode = keyboard.nextLine();
		String[] code = sCode.split("\\s+");

		System.out.print("Text: ");
		for(int i=0; i<code.length; i++)
			System.out.print(table.searchText(code[i]));
		System.out.println("");
	}
}

//DIZIONARIO con coppie (carattere ascii, codice binario)
class Dictionary
{
	Pair[] pair = new Pair[27];		//array contenente le coppie
	int index = 0;					//indice per il riempimento dell'array

	//Metodo che restituisce il carattere, in base al codice binario inserito
	public String searchText(String s)
	{
		String retValue = "";
		for(int i=0; i<pair.length; i++)		//semplice ricerca lineare
		{
			if(pair[i].getBin().equals(s))
				retValue = pair[i].getText(); 	//restituzione del carattere
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
	class Pair
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