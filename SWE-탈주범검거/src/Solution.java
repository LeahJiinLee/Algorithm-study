import java.util.*;
import java.io.*;
class Location {
	int x;
	int y;
	int t;
	public Location (int x, int y, int t) {
		this.x=x;
		this.y=y;
		this.t=t;
	}
}
class Combination {
	int x;
	int y;
	String s;
	public Combination (int x, int y, String s ) {
		this.x=x;
		this.y=y;
		this.s=s;
	}
}
public class Solution {
	static int N;
	static int M;
	static int R;
	static int C;
	static int L;
	static int map[][];
	static int visited[][];
	static ArrayList<Combination> comb[]= new ArrayList[8];
	static Queue<Location> que;
	static int ans;
	
	static void search (int x, int y, int t) {
		que.add(new Location(x,y,t));
		
		while (!que.isEmpty()) {
			
			Location curr = que.poll();
			ans++;
			
			
			int pipe = map[curr.x][curr.y]; //현재 배수관 정보
			for (int i=0;i<comb[pipe].size(); i++) {
				int next_x= curr.x+ comb[pipe].get(i).x;
				int next_y= curr.y+ comb[pipe].get(i).y;
				String next_s= comb[pipe].get(i).s;
				if (next_x>=0 && next_x<N && next_y>=0 && next_y<M) {
					if (map[next_x][next_y]!=0 && visited[next_x][next_y]!=1) {
						for (int j=0; j<next_s.length(); j++) {
							int next_p= next_s.charAt(j)-'0';
							if (map[next_x][next_y]==next_p && curr.t-1>0) {
								visited[next_x][next_y]=1;
								que.add(new Location(next_x, next_y,curr.t-1 ));
								break;
							}
						}
						
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		for (int i=0; i<8; i++) {
			comb[i]= new ArrayList<Combination>();
		}
		comb[1].add(new Combination(1,0, "1247"));
		comb[1].add(new Combination(-1,0, "1256"));
		comb[1].add(new Combination(0,-1, "1345"));
		comb[1].add(new Combination(0,1, "1367"));
		
		comb[2].add(new Combination(-1,0, "1256"));
		comb[2].add(new Combination(1,0, "1247"));
		
		comb[3].add(new Combination(0,-1, "1345"));
		comb[3].add(new Combination(0,1, "1367"));
		
		comb[4].add(new Combination(-1,0, "1256"));
		comb[4].add(new Combination(0,1, "1367"));
		
		comb[5].add(new Combination(1,0,"1247"));
		comb[5].add(new Combination(0,1, "1367"));
		
		comb[6].add(new Combination(1,0, "1247"));
		comb[6].add(new Combination(0,-1, "1345"));
		
		comb[7].add(new Combination(-1,0,"1256"));
		comb[7].add(new Combination(0,-1, "1345"));
		
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		
		
		int T= Integer.parseInt(br.readLine());
		
		for (int tc= 0; tc<T; tc++) {
			
			String input= br.readLine();
			StringTokenizer st= new StringTokenizer(input);
			N=Integer.parseInt(st.nextToken()); //세로
			M= Integer.parseInt(st.nextToken()); //가로
			R= Integer.parseInt(st.nextToken());
			C= Integer.parseInt(st.nextToken());
			L= Integer.parseInt(st.nextToken());
			map= new int [N][M];
			visited = new int [N][M];
			que= new LinkedList<Location>();
			
			for (int i=0; i<N; i++) {
				input = br.readLine();
				st= new StringTokenizer (input);
				for (int j=0; j<M; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			visited[R][C]=1;
			ans=0;
			search(R,C,L);
			System.out.println("#" + (tc+1) + " "+ ans);
		}
	}

}
