import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		TreeMap <Integer, Integer> tmap;
		
		int T= Integer.parseInt(br.readLine());//테케 갯수
		for (int tc=0; tc<T; tc++) {
			tmap= new TreeMap<>();
			int k= Integer.parseInt(br.readLine());
			String input;
			StringTokenizer st;
			for (int i=0; i<k; i++) {
				input= br.readLine();
				st= new StringTokenizer(input);
				String token1= st.nextToken();
				String token2= st.nextToken();
				if (token1.equals("I")) {
					tmap.put(Integer.parseInt(token2),tmap.getOrDefault(Integer.parseInt(token2),0)+1);
				}
				else {
					if(tmap.isEmpty()) {
						continue;
					}
					if (token2.equals("-1")) {
						
						int min= tmap.firstKey();
						if (tmap.get(min)==1) {
							tmap.remove(min);
						}
						else {
							tmap.put(min,tmap.get(min)-1 );
						}
						
					}
					else {
						int max= tmap.lastKey();
						if(tmap.get(max)==1) {
							tmap.remove(max);
						}
						else {
							tmap.put(max, tmap.get(max)-1);
						}
					
					}
				}
			}
			if (tmap.isEmpty()) {
				System.out.println("EMPTY");
			}
			else {
				int min= tmap.firstKey();
				int max= tmap.lastKey();
				System.out.println(max+" "+ min);
			}
			
		}
	
	}

}
