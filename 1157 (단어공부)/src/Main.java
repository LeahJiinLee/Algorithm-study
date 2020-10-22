import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int max=0;
		char result='A';
		char word[]= input.toCharArray();
		
		int alphabet[]= new int[26];
		for (int i=0; i<input.length(); i++) {
			alphabet[Character.toUpperCase(word[i])-'A']++;
		}
		for (int i=0; i<alphabet.length; i++) {
			if (alphabet[i]>max)
				{max=alphabet[i];
				result = (char)(i+65);
				}
			else if (alphabet[i]==max) result= '?';
		}
		System.out.println(result);
	}

}
