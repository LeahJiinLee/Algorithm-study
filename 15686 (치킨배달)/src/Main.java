import java.util.*;
import java.io.*;
class Location {
	int r;
	int c;
	int visited=0;
	public Location (int r, int c) {
		this.r=r;
		this.c=c;
		
	}
}
public class Main {
	static int N;
	static int M;
	static int village[][];
	static ArrayList<Location> chicken= new ArrayList<Location>();
	static ArrayList<Location> house= new ArrayList<Location>();
	static Location[] chicken2;
	
	static int answer=Integer.MAX_VALUE;
	public static int cal () {
		int sum=0;
		for (int i=0; i<house.size();i++) {
			int min=Integer.MAX_VALUE;
			int house_r= house.get(i).r;
			int house_c= house.get(i).c;
			for (int j=0;j<M; j++) {
				Location temp=chicken2[j];
				int temp_r= temp.r;
				int temp_c= temp.c;
				min= Math.min(Math.abs(temp_r-house_r)+ Math.abs(temp_c-house_c), min);
			}
			
			sum+=min;
			//System.out.println(sum);
		}
		
		return sum;
	}
	public static void comb (int count, int start) {
		if (count==M) {
			//System.out.println(chicken2.length);
			answer= Math.min(answer, cal());
			//System.out.println(answer);
			return;
		}
		for (int idx=start; idx<chicken.size();idx++) {
			chicken2[count]=chicken.get(idx);
			comb(count+1,idx+1);
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		chicken2=new Location[M];
		village= new int[N][N];
		for (int i=0; i<N; i++) {
			input= br.readLine();
			st= new StringTokenizer(input);
			for (int j=0; j<N; j++) {
				village[i][j]=Integer.parseInt(st.nextToken());
				if (village[i][j]==2) {
					chicken.add(new Location(i,j));
				}
				else if(village[i][j]==1) {
					house.add(new Location(i,j));
				}
			}
		}
		//System.out.println(chicken.size());
		comb(0,0);
		System.out.println(answer);
	}

}
