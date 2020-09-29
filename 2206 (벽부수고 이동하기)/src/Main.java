import java.io.*;
import java.util.*;
class Location {
	int x;
	int y;
	int path;
	int wall;
	public Location (int x, int y, int path, int wall) {
		this.x=x;
		this.y=y;
		this.path=path;
		this.wall=wall;
	}
}
public class Main {
	static int N,M;
	static int dir_x[]= {-1,1,0,0};
	static int dir_y[]= {0,0,-1,1};
	static int map [][];
	static int visited[][][];
	static int ans=1000001;
	public static void bfs (int x, int y) {
		Queue<Location> q= new LinkedList<Location>();
		int wall=0; 
		q.add(new Location(x,y,1,0));
		visited[x][y][wall]=1;
		while (!q.isEmpty()) {
			Location curr= q.poll();
			//System.out.print(curr.x+","+curr.y+" ");
			if (curr.x==N-1 && curr.y==M-1) {
				//System.out.println();
				ans= Math.min(ans, curr.path);
				continue;
			}
			for (int i=0; i<4; i++) {
				int next_x= curr.x+dir_x[i];
				int next_y= curr.y+dir_y[i];
				if (next_x<0||next_x>=N|| next_y<0||next_y>=M) continue;
				if (curr.wall==0) {//�� ���� x
					if(map[next_x][next_y]==0 && visited[next_x][next_y][0]==0) {//���� �ƴϰ� && �湮�� ��X
						q.add(new Location(next_x,next_y,curr.path+1, 0));
						visited[next_x][next_y][curr.wall]=1;//�湮 ǥ��
					}
					else if (map[next_x][next_y]==1 && visited[next_x][next_y][1]==0) {//�� && �湮���� x
						q.add(new Location (next_x, next_y, curr.path+1,1)); //����
						visited[next_x][next_y][1]=1;// �� �� ��ο� �湮 ǥ��
					}
				}
				else {//������ o
					if(map[next_x][next_y]==0 && visited[next_x][next_y][1]==0) {//�� x && �� �� ���¿��� �湮����x
						q.add(new Location(next_x,next_y,curr.path+1, 1));
						visited[next_x][next_y][1]=1;
					}
				}
			}
		}
		if (ans ==1000001)
		ans= -1;
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		map = new int [N][M];
		visited= new int [N][M][2];
		
		for(int i=0; i<N; i++) {
			input= br.readLine();
			for (int j=0; j<M;j++) {
				map[i][j]= input.charAt(j)-'0';
			}
		}
		bfs(0,0);
		System.out.println(ans);
	}

}
