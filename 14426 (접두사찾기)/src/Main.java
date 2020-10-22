import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		
		ArrayList<String> word= new ArrayList<String>();
	
		int count=0;
		for (int i=0; i<N; i++) {
			word.add(br.readLine());
		}
		for (int i=0; i<M; i++) {
			input= br.readLine();
			for (int j=0; j<word.size(); j++) {
				String temp= word.get(j);
				if (temp.substring(0,input.length()).equals(input)){
					count++;
					break;
				
				}
			}
		}
		System.out.println(count);
	}

}
