import java.util.*;
import java.io.*;
class Location {
	int x;
	int y;
	int level;
	public Location (int x, int y, int level) {
		this.x=x;
		this.y=y;
		this.level= level;
	}
}
public class Main4 {
	static int L;
	static int map[][];
	static int visited[][];
	static int dir_x[]= {-2, -1, 1,2,2,1,-1,-2};
	static int dir_y[]= {1,2,2,1,-1,-2, -2,-1};
	static Queue <Location> que= new LinkedList <Location>();
	static int ans;
	static int bfs(int st_x, int st_y, int ds_x, int ds_y) {
		que.add(new Location (st_x, st_y,0));
		while (!que.isEmpty()) {
			Location temp= que.poll();
			for (int i=0; i<8; i++) {
				int nextX= temp.x+dir_x[i];
				int nextY= temp.y+dir_y[i];
				int nextL= temp.level+1;
				if (nextX==ds_x && nextY==ds_y) {
					
					return nextL;
				}
				if (nextX>=0 && nextX<L && nextY>=0 && nextY<L) {
					if (visited[nextX][nextY]!=1) {
					que.add(new Location (nextX, nextY, nextL));
					visited[nextX][nextY]=1;
					
					}
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for (int tc=0; tc<T; tc++) {
			ans=0;
			que.clear();
			L= Integer.parseInt(br.readLine());
			visited= new int[L][L];
			String input = br.readLine();
			StringTokenizer st= new StringTokenizer(input);
			int start_x=Integer.parseInt(st.nextToken());
			int start_y=Integer.parseInt(st.nextToken());
			input= br.readLine();
			st= new StringTokenizer(input);
			int dest_x=Integer.parseInt(st.nextToken());
			int dest_y=Integer.parseInt(st.nextToken());
			if (start_x==dest_x && start_y==dest_y) System.out.println(0);
			else {
			visited[start_x][start_y]=1;
			ans=bfs (start_x, start_y, dest_x, dest_y);
			System.out.println(ans);
			}
		}
	}

}
