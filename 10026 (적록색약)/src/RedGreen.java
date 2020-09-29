import java.io.*;
import java.util.*;
class Node {
	int x;
	int y;
	 Node (int x, int y) {
		this.x=x;
		this.y=y;
	}
}
public class RedGreen {
	static char grid[][];
	static int visited[][];
	static int N;
	static int dir_x[]= {-1,1,0,0};
	static int dir_y[]= {0,0,-1,1};
	static Queue <Node> q = new LinkedList<Node> ();
	static int result1=0;
	static int result2=0;
	static int count=0;
	public static void normal (int x, int y) {
		
		q.add(new Node(x,y));
		while (!q.isEmpty()) {
			
			Node current = q.poll();//큐에서 꺼냄
			//count++;
			for (int i=0; i<4; i++) { //위 아래 좌 우로 탐색
				int new_x=current.x+dir_x[i];
				int new_y= current.y+dir_y[i];
				if (new_x>=0 && new_y>=0 
						&& new_x<N &&new_y<N
						&& visited[new_x][new_y]==0
						&&grid[new_x][new_y]==grid[current.x][current.y]) {
					q.add(new Node(new_x, new_y));
					visited[new_x][new_y]=1;		
				
			}
				
		}
		
	}
		count+=1;//같은 색 구역 다 찾으면 
	}
	public static void rg (int x, int y) {
		q.add(new Node(x,y));
		while (!q.isEmpty()) {
			
			Node current = q.poll();//큐에서 꺼냄
			//count++;
			for (int i=0; i<4; i++) { //위 아래 좌 우로 탐색
				int new_x=current.x+dir_x[i];
				int new_y= current.y+dir_y[i];
				if (new_x>=0 && new_y>=0 && new_x<N &&new_y<N && visited[new_x][new_y]==0) //NxN 사이에 있다면
					{ 
					if (grid[current.x][current.y]==grid[new_x][new_y]
							|| grid[current.x][current.y]=='R'&& grid[new_x][new_y]=='G'
							|| grid[current.x][current.y]=='G'&& grid[new_x][new_y]=='R')
					{
						q.add(new Node(new_x,new_y));
						visited[new_x][new_y]=1;
					}
					}
					
						
				
			}
			
		}
		count+=1;//같은 색 구역 다 찾으면 
	}
		
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		N= Integer.parseInt(input);
		grid=new char [N][N];
		visited= new int [N][N];
		
		for (int i=0; i<N; i++) {
			input= br.readLine();
			for (int j=0; j<N;j++) {
				grid[i][j]= input.charAt(i);
			}// 정보 저장
		}
		for (int i=0;i<2; i++) {
			count=0;
			for (int p=0; p<N; p++) {
				for (int q=0; q<N; q++)
					visited[p][q]=0; //방문여부 초기화
			}
			for (int j=0; j<N; j++) {
				for (int k=0; k<N; k++) {
					if (visited[j][k]==0) {
						visited[j][k]=1;
						if (i==0) {
							normal(j,k);
						}
						else if (i==1) {
							rg(j,k);
						}
					}
				}
			}
			System.out.print(count+ " ");
		}
		
	}

}
