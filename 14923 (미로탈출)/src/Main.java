import java.io.*;
import java.util.*;
class Location{
	int r;
	int c;
	int magic;
	int dist;
	public Location (int r, int c, int magic, int dist) {
		this.r=r;
		this.c=c;
		this.magic=magic;
		this.dist=dist;
					
	}
}
public class Main {
	static int N,M;
	static int maze[][];
	static int dest_r, dest_c;
	static int visited[][][];
	static int dir_r[]= {-1,1,0,0};
	static int dir_c[]= {0,0,-1,1};
	static int answer=Integer.MAX_VALUE;
	public static void bfs (int r, int c) {
		Queue<Location> q= new LinkedList<Location>();
		q.add(new Location(r,c,0,0));
		visited[r][c][0]=1;
		
		while (!q.isEmpty()) {
			Location temp= q.poll();
			if (temp.r==dest_r-1 && temp.c==dest_c-1) {
				answer= Math.min(answer, temp.dist);
				continue;
			}
			for (int i=0; i<4; i++) {
				int next_r= temp.r+dir_r[i];
				int next_c= temp.c+dir_c[i];
				if (next_r<0 || next_r>=N || next_c<0 || next_c>=M) continue;
				if (temp.magic==0) {//º®À» ±üÀû x
					if (maze[next_r][next_c]==0 && visited[next_r][next_c][0]==0) {
						visited[next_r][next_c][0]=1;
						q.add(new Location(next_r, next_c,0,temp.dist+1));
					}
					else if (maze[next_r][next_c]==1 && visited[next_r][next_c][1]==0) {
						q.add(new Location (next_r, next_c,1, temp.dist+1));
						visited[next_r][next_c][1]=1;
					}
					
				}
				else {
					if (maze[next_r][next_c]==0 && visited[next_r][next_c][1]==0) {
						q.add(new Location(next_r, next_c, 1, temp.dist+1));
						visited[next_r][next_c][1]=1;
					}
				}
			}
		}
		if (answer==Integer.MAX_VALUE) {
			answer=-1;
		}
		System.out.println(answer);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		maze= new int[N][M];
		visited=new int[N][M][2];//ÁöÆÎÀÌ·Î ¹Ù²å´ÂÁö ¿©ºÎ
		input= br.readLine();
		st= new StringTokenizer(input);
		int start_r= Integer.parseInt(st.nextToken());
		int start_c= Integer.parseInt(st.nextToken());
		input= br.readLine();
		st= new StringTokenizer(input);
		dest_r= Integer.parseInt(st.nextToken());
		dest_c= Integer.parseInt(st.nextToken());
		
		for (int i=0; i<N; i++) {
			input= br.readLine();
			st= new StringTokenizer(input);
			for (int j=0;j<M; j++) {
				maze[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		bfs(start_r-1, start_c-1);
	}

}
