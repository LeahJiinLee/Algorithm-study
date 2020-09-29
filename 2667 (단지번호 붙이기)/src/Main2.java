import java.io.*;
import java.util.*;
class Location {
	int x;
	int y;
	Location (int x, int y) {
		this.x=x;
		this.x=y;
	}
}
public class Main2 {
	static int N;
	static int[][] house;
	static int [][] visited;
	static int dir_x[]= {-1,1,0,0};
	static int dir_y[]= {0,0,-1,1};
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int count=0;
	static Stack<Location> stk= new Stack<Location>(); 

	static void dfs (int x, int y) {
		stk.push(new Location(x,y));
		while (!stk.isEmpty() ) {
			Location current= stk.pop();
			for (int i=0; i<4; i++) {
				int nextX=current.x +dir_x[i];
				int nextY= current.y+dir_y[i];
				System.out.println(current.x+ ", " +current.y );
				if (nextX >=0 && nextX<N 
						&& nextY>=0 && nextY<N
						//&& visited[nextX][nextY]==0
						//&& house[nextX][nextY]==1
						) {
					System.out.print(nextX+ ", " +nextY );
					stk.push(new Location(nextX, nextY));
					visited[nextX][nextY]=1;
					count++;
				}
			}
		}
		list.add(count);
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 크기 
		house = new int [N][N];
		visited= new int [N][N];
		for (int i=0; i<visited.length; i++) {
			for (int j=0; j<visited[i].length; j++)
			visited[i][j]=0;
		}
		for (int i=0; i<N; i++) {
			String input= br.readLine();
			for (int j=0; j<N; j++) {
				house[i][j]= input.charAt(j)-'0';
			}
		}//단지 정보 입력
//		for (int i=0; i<visited.length; i++) {
//			for (int j=0; j<visited[i].length; j++)
//			System.out.print(house[i][j]);
//			System.out.println();
//		}
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (house[i][j]==1&& visited [i][j]==0) {
					visited[i][j]=1;
					count=1;
					dfs(i,j);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
