import java.io.*;
import java.util.*;
public class Main {
	static int N,K;
	static int coin[];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		N= Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		coin= new int[N+1];
	
		int temp=K;
		for (int i=1; i<=N; i++) {
			coin[i]=Integer.parseInt(br.readLine());
		}

		int sum=0;
		for (int i=N; i>=1; i--) {
			if (coin[i]>temp) continue;
			
			sum+=temp/coin[i];
			temp%=coin[i];
			if (temp==0) {
				break;
			}
		}
	
		System.out.println(sum);
	}

}
