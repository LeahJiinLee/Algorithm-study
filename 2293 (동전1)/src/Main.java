import java.io.*;
import java.util.*;
public class Main {
	static int n, k;
	static int DP[];
	static int coin[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		n= Integer.parseInt(st.nextToken());
		k= Integer.parseInt(st.nextToken());
		DP= new int [k+1];
		coin = new int [n+1];
		Arrays.fill(DP, 0);
		DP[0]=1;//동전 아무것도 사용 안함
		
		for (int i=1; i<=n; i++) {
			coin[i]=Integer.parseInt(br.readLine());
		}
		for (int i=1; i<=n; i++) {
			for (int j=coin[i]; j<=k; j++) {
				DP[j]+=DP[j-coin[i]];
			}
		}
		System.out.print(DP[k]);
		}

}
