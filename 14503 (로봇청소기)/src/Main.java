import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int room[][];
	static int dir_x[]= {-1,0,1,0};
	static int dir_y[]= {0,1,0,-1};
	static int answer;
	
	static int clean (int r, int c, int d) {
		int count=0;
		int check=0;
		int next_x, next_y;
		boolean flag=true;
		while (flag) {
			if (room[r][c]==0) {
				room[r][c]=2;
				count++;
			}//1¹ø
			while (true) {
				if (check==4) {
					//ÈÄÁø 
					next_x=r-dir_x[d];
					next_y=c-dir_y[d];
					if (room[next_x][next_y]==1) {
						return count;
					}//d
					else {
						check=0;
						r=next_x;
						c=next_y;
					}//c
				}
				d=(d+3)%4;
				next_x=r+dir_x[d];
				next_y=c+dir_y[d];
				
				if (next_x>=0 && next_x<N && next_y>=0 && next_y<M) {
					if(room[next_x][next_y]==0) {
						check=0;
						r=next_x;
						c=next_y;
						break;
					}
					else {
						check++;
					}
				}
				
			}
		}
		
		return count;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		int r,c,d;
		room= new int[N][M];
		
		input= br.readLine();
		st= new StringTokenizer(input);
		r= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		d= Integer.parseInt(st.nextToken());
		
		for (int i=0; i<N; i++) {
			input= br.readLine();
			st= new StringTokenizer(input);
			for (int j=0; j<M; j++) {
				room[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		answer=clean (r,c,d);
		System.out.println(answer);
	}

}
