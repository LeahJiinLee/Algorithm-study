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
	static int lab[][];
	static int lab2[][];
	static int visited[][];
	static int dir_r[]= {-1,1,0,0};
	static int dir_c[]= {0,0,-1,1};
	static int N,M;
	static Location [] space;
	static ArrayList<Location> list= new ArrayList<Location>();
	static ArrayList<Location> virus= new ArrayList<Location>();
	static int answer=0;
	public static int bfs () {
		int area=0;
		visited= new int [N][M];
		Queue<Location> q= new LinkedList<Location>();
		for (int i=0; i<virus.size(); i++) {
			Location loc= virus.get(i);
			int virus_r= loc.r;
			int virus_c= loc.c;
			if (lab2[virus_r][virus_c]==2 && visited[virus_r][virus_c]==0) {
				q.add(new Location(virus_r,virus_c));
				visited[virus_r][virus_c]=1;
				while (!q.isEmpty()) {
					Location temp= q.poll();
					for (int d=0; d<4; d++) {
						int next_r= temp.r+dir_r[d];
						int next_c= temp.c+dir_c[d];
						if (next_r<0 || next_r>=N || next_c<0 || next_c>=M || lab2[next_r][next_c]==1 ||
								lab2[next_r][next_c]==2) continue;
						if (visited[next_r][next_c]==0 && lab2[next_r][next_c]==0) {
							q.add(new Location(next_r, next_c));
							lab2[next_r][next_c]=2;
							visited[next_r][next_c]=1;
						}
					}
				}
			}
		}
		for (int i=0; i<lab2.length; i++) {
			for (int j=0; j<lab2[i].length; j++) {
				//System.out.print(lab2[i][j]);
				if (lab2[i][j]==0) {
					area++;
				}
			}
			//System.out.println();
		}
		return area;
	}
	public static void comb(int count, int start) {
		if (count==3) {
			lab2= new int[N][M];
			
			for (int i=0; i<lab2.length; i++) {
				for (int j=0; j<lab2[i].length; j++) {
					lab2[i][j]=lab[i][j];
				}
				
			}
			for (int i=0; i<space.length; i++) {
				int temp_r= space[i].r;
				int temp_c= space[i].c;
				//System.out.println(temp_r+","+ temp_c);
				lab2[temp_r][temp_c]=1;
				
			}
			
			answer= Math.max(answer,bfs() );
			//System.out.println(answer);
			return;
		}
		for (int idx=start; idx<list.size(); idx++) {
			space[count]=list.get(idx);
			comb(count+1, idx+1);
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		lab= new int[N][M];
		space= new Location[3];
		for (int i=0; i<N; i++) {
			input= br.readLine();
			st= new StringTokenizer(input);
			for (int j=0; j<M; j++) {
				lab[i][j]= Integer.parseInt(st.nextToken());
				if (lab[i][j]==0) {
					list.add(new Location(i,j));
				}
				else if (lab[i][j]==2) {
					virus.add(new Location(i,j));
				}
			}
		}
		comb(0,0);
		System.out.println(answer);
	}

}
