import java.io.*;
import java.util.*;
class Node {
	int x;
	int y;
	ArrayList <String >list;
	 Node (int x, int y) {
		this.x=x;
		this.y=y;
		this.list= new ArrayList<String>();
	}
}

public class Solution {
	ArrayList<ArrayList<String>> list4 = new ArrayList<ArrayList<String>>();
	static int house[][];
	static int visited[][];
	static int N;
	static int dir_x[]= {-1,1,0,0};
	static int dir_y[]= {0,0,-1,1};
	static Queue <Node> q = new LinkedList<Node> ();
	static ArrayList<Integer> list= new ArrayList<Integer>();
	static Stack<Node> stck= new Stack<Node> ();
	static int count=0;
	/*
	 
0110100
0110101
1110101
0000111
0100000
0111110
0111000
	 */
	public static void dfs (int x, int y) {
		stck.push(new Node(x,y));
		while (!stck.isEmpty()) {
			Node current = stck.pop();
			for (int i=0; i<4; i++) {
				int next_x=current.x+dir_x[i];
				int next_y= current.y+dir_y[i];
				if (next_x>=0 && next_x<N && next_y>=0 && next_y<N 
						&& visited[next_x][next_y]==0 && house[next_x][next_y]==1) {
					
					visited[next_x][next_y]=1;
					stck.push(new Node(next_x, next_y));
					count++;
					
					
			}
		}
	}
		list.add(count);
	}
	public static void bfs (int x, int y) {
		q.add(new Node (x,y));
		while (!q.isEmpty()) {
			Node current = q.poll();
			for(int i=0; i<4; i++) {
				int next_x=current.x+dir_x[i];
				int next_y= current.y+dir_y[i];
				if (next_x>=0 && next_x<N && next_y>=0 && next_y<N 
						&& visited[next_x][next_y]==0 && house[next_x][next_y]==1) {
					q.add(new Node(next_x, next_y));
					visited[next_x][next_y]=1;
					count++;
				}
			}
		}
		list.add(count);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		String input= br.readLine();
		N= Integer.parseInt(input);
		house= new int [N][N];
		visited= new int[N][N];

		for (int p=0; p<N;p++) {
			for (int q=0; q<N; q++) {
				visited[p][q]=0;
			}
		for (int i=0; i<N;i++) {
			input= br.readLine();
			for (int j=0; j<N; j++) {
				house[i][j]= input.charAt(j)-'0';
			}
		}
	
			for (int k=0; k<N; k++) {
				for (int j=0; j<N; j++) {
					if (house[k][j]==1 && visited[k][j]==0) {
						visited[k][j]=1;
						count=1;
						dfs(k,j);						
					}
					
				}
			}
			System.out.println(list.size());
			Collections.sort(list);
			for (int idx=0; idx<list.size();idx++)
			System.out.println(list.get(idx));
		}
		
		}
	

}
