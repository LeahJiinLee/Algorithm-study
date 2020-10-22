import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int wine[] = new int[N];
		int DP[]= new int[N];
		 for (int i=0; i<N; i++) {
			 wine[i]= Integer.parseInt(br.readLine());
			 
		 }
		 if (N==1) {
				DP[0]=wine[0];
			}
		 else if (N==2) {
			DP[0]=wine[0];
			DP[1]=wine[0]+wine[1];
		 }
		 else {
		DP[0]=wine[0];
		DP[1]=wine[0]+wine[1];
		DP[2] = Math.max(DP[1],wine[0]+wine[2]);
		DP[2] = Math.max(DP[2],wine[1]+wine[2]); //23
		
		for(int i=3; i<N; i++) {
			DP[i]= Math.max(DP[i-1], DP[i-3]+wine[i]+wine[i-1]); //3, 1
			DP[i]= Math.max(DP[i],DP[i-2]+wine[i]);// 
		}
		
		 }
		 System.out.println(DP[N-1]);
	}

}
