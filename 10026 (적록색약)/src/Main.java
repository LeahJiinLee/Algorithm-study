import java.io.*;
import java.util.*;
class Node {
	int x;
	int y;
	public Node(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
public class Main {

	static int N;
	static char map[][];
	static int visited[][];
	static int dir_x[] = {-1,1,0,0};
	static int dir_y[] = {0,0,-1,1};
	static Queue<Node> queue = new LinkedList<Node>();
	//static List <Integer> list = new ArrayList<Integer> ();
	static int count;
	public static void BFS(int x, int y) {
		queue.add(new Node(x,y));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i=0; i<4; i++) {
				int nextX= node.x+dir_x[i]; 
				int nextY= node.y+dir_y[i]; //상하좌우탐색 
				if (nextX>=0 && nextX<N &&nextY>=0 && nextY<N
						&&visited[nextX][nextY]==0 
						&&map[nextX][nextY]==map[x][y]) {
					 //같은 색이라면
					queue.add(new Node(nextX, nextY));
					visited[nextX][nextY]=1;
					
				}
			}
		}
		count+=1;
	}
	public static void BFS2 (int x, int y) {
		queue.add(new Node(x,y));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i=0; i<4; i++) {
				int nextX= node.x+dir_x[i]; 
				int nextY= node.y+dir_y[i]; //상하좌우탐색 
				if (nextX>=0 && nextX<N &&nextY>=0 && nextY<N
						&&visited[nextX][nextY]==0 
						) {
					
					if (map[nextX][nextY]==map[x][y]
							||map[x][y]=='R'&&map[nextX][nextY]=='G'
							||map[x][y]=='G' && map[nextX][nextY]=='R' ) //같은 색이라면
					{queue.add(new Node(nextX, nextY));
					visited[nextX][nextY]=1;
					}
				}
			}
		}
		count+=1;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		String input;
		N=Integer.parseInt(br.readLine());
		map= new char[N][N];
		visited= new int[N][N];
		for (int i=0; i<N; i++) {
			input= br.readLine();
			for(int j=0; j<input.length(); j++) {
				map[i][j]=input.charAt(j);
			}
		}
		for (int i=0 ;i<2; i++) {
			count=0;
			for (int j=0; j<N; j++) {
				for (int k=0; k<N; k++) {
					visited[j][k]=0;//초기화시켜줌
				}
			}
			
			
			for (int p=0; p<N; p++) {
				for (int q=0; q<N; q++) {
					if (visited[p][q]==0) {
						visited[p][q]=1;
						//count=0;
						if (i==0)
						{	BFS(p,q);}
						else if (i==1)
							{BFS2(p,q);}
					}
				}
			}
			//list.add(count);
			System.out.print(count+ " ");
		}

	}

}
