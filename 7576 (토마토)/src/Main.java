import java.io.*;
import java.util.*;
class Location {
	int x;
	int y;
	int day;
	public Location(int x, int y, int day) {
		this.x=x;
		this.y=y;
		this.day=day;
	}
}
public class Main {
	static int dir_x[]= {-1,1,0,0};
	static int dir_y[]= {0,0,-1,1};
	static int box[][];
	static int M,N;
	static int visited[][];
	static int bfs() {
		Queue<Location> q= new LinkedList<Location>();
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (box[i][j]==1) {
					q.add(new Location(i,j,0));
					visited[i][j]=1;
				}
			}
		}

	
		while(!q.isEmpty()) {
			Location temp = q.poll();
			for (int i=0; i<4; i++) {
				int next_X= temp.x+dir_x[i];
				int next_Y= temp.y+dir_y[i];
				if (next_X<0 || next_X>=N || next_Y<0 ||next_Y>=M) continue;
				if (visited[next_X][next_Y]==0 && box[next_X][next_Y]!=-1) {
					if (box[next_X][next_Y]!=1) {//안익음?
						box[next_X][next_Y]=box[temp.x][temp.y]+1;//익게 함
						q.add(new Location(next_X, next_Y,temp.day+1));
						visited[next_X][next_Y]=1;
					}
				}
			}


		}
		int max=-1;
		for (int i=0 ;i<N; i++) {
			for (int j=0; j<M; j++) {
				
				if (box[i][j]==0) {
					System.out.println(-1);
					return -1;
				
				}
				else if (box[i][j]>=1){
					if (box[i][j]>max) max= box[i][j];
				}
			}

		}


		System.out.println(max-1);
		return max-1;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		M= Integer.parseInt(st.nextToken());
		N= Integer.parseInt(st.nextToken());
		box= new int[N][M];
		visited= new int [N][M];
		for (int []arr: visited) {
			Arrays.fill(arr, 0);
		}
		for (int i=0; i<N; i++) {
			input= br.readLine();
			st= new StringTokenizer(input);
			for (int j=0; j<M; j++) {
				box[i][j]= Integer.parseInt(st.nextToken());
			}
		}
				
			bfs();
	
	}

}
