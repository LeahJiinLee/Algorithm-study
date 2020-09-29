import java.io.*;
import java.util.*;
public class Main {
	static int N,K;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		N= Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		int weight[]= new int [N];
		int value[]= new int [N];
		int DP[][]= new int[N+1][K+1];
		for (int i=0; i<N; i++) {
			input = br.readLine();
			st= new StringTokenizer(input);
			int w= Integer.parseInt(st.nextToken());
			weight[i]=w;
			int v= Integer.parseInt(st.nextToken());
			value[i]=v;
		}
		for (int i=1; i<=N; i++) {
			for (int j=0; j<=K; j++) {
				if (weight[i-1]<=j) {
					DP[i][j]= Math.max(value[i-1]+DP[i-1][j-weight[i-1]], DP[i-1][j]);
				}
				else {
					DP[i][j]=DP[i-1][j];
				}
			}
		}
		System.out.println(DP[N][K]);
	}

}
