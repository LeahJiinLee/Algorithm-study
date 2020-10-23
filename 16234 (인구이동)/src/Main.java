import java.io.*;
import java.util.*;

class Location {
	int r;
	int c;
	public Location (int r, int c) {
		this.r=r;
		this.c=c;
	}
}
public class Main {
	static int N,L,R;
	static int country[][];
	static int count;
	static int dir_r[]= {-1,1,0,0};
	static int dir_c[]= {0,0,-1,1};
	static int visited[][];
	static boolean flag;
	static ArrayList<ArrayList<Location>> list = new ArrayList<ArrayList<Location>>();
	public static void bfs (int r, int c) {
		//visited= new int[N][N];
		Queue<Location> q= new LinkedList<Location>();
		ArrayList<Location> neighbor= new ArrayList<Location>();
		q.add(new Location(r,c));
		visited[r][c]=1;
		while (!q.isEmpty()) {
			Location temp= q.poll();
			neighbor.add(temp);
			for (int i=0; i<4; i++) {
				int next_r= temp.r+dir_r[i];
				int next_c= temp.c+dir_c[i];
				if (next_r<0 || next_r>=N || next_c<0 ||next_c>=N) continue;
				if (visited[next_r][next_c]==0) {
					if (Math.abs(country[temp.r][temp.c]-country[next_r][next_c])>=L &&
							Math.abs(country[temp.r][temp.c]-country[next_r][next_c])<=R) {
						//neighbor.add(new Location(next_r, next_c));
						visited[next_r][next_c]=1;
						q.add(new Location(next_r, next_c));
					}
				}
			}
			
		}
		if (neighbor.size()==1) {
			//System.out.println(0);
			return;
		}
		list.add(neighbor);
		//System.out.println(neighbor.size());
		//update();
	}
	public static void update() {
		if (list.size()==0) {
			flag=false;
			return;
		}
		count++;
		for (int i=0; i<list.size(); i++) {
			//count++;
			ArrayList<Location> temp= list.get(i);//각 연합국에 속한 나라
			int sum=0;
			for (int j=0; j<temp.size(); j++ ){
				sum+=country[temp.get(j).r][temp.get(j).c];
			}
			for (int k=0; k<temp.size(); k++) {
				country[temp.get(k).r][temp.get(k).c]=sum/temp.size();
			}
			
		}
//		System.out.println("--------");
//		for (int i=0; i<N; i++) {
//			for (int j=0; j<N; j++) {
//				System.out.print(country[i][j]+ " ");
//			}
//			System.out.println();
//		}
		list.clear();
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		N= Integer.parseInt(st.nextToken());
		L= Integer.parseInt(st.nextToken());
		R= Integer.parseInt(st.nextToken());
		country= new int[N][N];
		visited= new int[N][N];
		for (int i=0; i<N; i++) {
			input= br.readLine();
			st= new StringTokenizer(input);
			for (int j=0; j<N; j++)
			{
				country[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		flag=true;
		do{
			for (int arr[]: visited) {
				Arrays.fill(arr, 0);
			}
			for (int i=0;i<N; i++) {
				for (int j=0; j<N; j++) {
					if (visited[i][j]==0)
					bfs(i,j);
					
				}
			}
			//count++;
			update();
			
		} while (flag);
		System.out.println(count);
		//bfs(0,0);
	}

}
