import java.io.*;
import java.util.*;
class Location {
	int x;
	int y;
	public Location (int x,int y) {
		this.x=x;
		this.y=y;
	}
}
public class Main {
	static int R;
	static int C;
	static int dir_x[]= {-1,1,0,0};
	static int dir_y[]= {0,0,-1,1};
	static char map[][];
	static int visited[][];
	static String str= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static int alpha[]= new int[str.length()];
	static int count=1;
	static int answer=1;
	public static void search (int x, int y) {
		char curr=map[x][y];
		
		
		alpha[str.indexOf(curr)]=1;
		for (int i=0; i<4; i++) {
			int next_x=x+dir_x[i];
			int next_y= y+dir_y[i];
			
			if (next_x<0 || next_x>=R ||next_y<0 || next_y>=C) continue;
			int temp= map[next_x][next_y];
			if (alpha[str.indexOf(temp)]==1) continue;
			count++;
			answer= Math.max(answer, count);
			search(next_x, next_y);
			
		}
		count--;
		alpha[str.indexOf(curr)]=0;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		map= new char [R][C];
		visited= new int [R][C];
		Arrays.fill(alpha, 0);
		for (int arr[]: visited) {
			Arrays.fill(arr, 0);
		}
		
		for (int i=0; i<R; i++) {
			input= br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j]= input.charAt(j);
			}
		}
		search(0,0);
		System.out.println(answer);
		
	}

}
