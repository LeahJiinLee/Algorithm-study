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

	static int L;
	static int map[][];
	static int visited[][];
	static int dir_x[] = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int dir_y[] = {-1, 1, -2, 2, -2, 2, -1, 1};
	static int count;
	static int fromX, fromY, toX, toY;
	static Queue<Node> queue = new LinkedList<Node>();
	public static void search(int x1, int y1) {
		
		queue.add(new Node(x1,y1));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.x==toX &&node.y==toY) return;
			for (int i=0; i<dir_x.length; i++) {
				int nextX= node.x+dir_x[i];
				int nextY= node.x+dir_y[i];
				if (nextX<L && nextX>=0 && nextY<L && nextY>=0
						&& visited[nextX][nextY]==0) {
					
					//map[nextX][nextY]= map[node.x][node.y]+1;	
					if (nextX==toX &&nextY==toY) {
						return;
					}
					//System.out.println(map[nextX][nextY]);
					visited[nextX][nextY]=1;
					count++;
					queue.add(new Node(nextX, nextY));
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		String input;
		StringTokenizer st;
		int T= Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			count=0;
			queue.clear();
			L=Integer.parseInt(br.readLine()); //체스판 크기
			map= new int [L][L];
			visited = new int [L][L];
			for (int i=0; i<L; i++) {
				for (int j=0; j<L; j++) {
					map[i][j]=0;
					visited[i][j]=0;
				}
			}
			input= br.readLine();
			st= new StringTokenizer(input, " ");
			fromX=Integer.parseInt(st.nextToken());
			fromY=Integer.parseInt(st.nextToken());
			input= br.readLine();
			st= new StringTokenizer(input, " ");
			toX=Integer.parseInt(st.nextToken());
			toY=Integer.parseInt(st.nextToken());
			
			visited[fromX][fromY]=1;
			search(fromX, fromY);
			System.out.println(count);
			//System.out.println(map[toX][toY]);
		}
		

	}

}
