import java.io.*;
import java.util.*;
/*
 for (int i=0;i<h; i++) {
			for (int j=0; j<w; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
 */
public class Main {

	static char map[][];
	static int moveX [] = {-1, 1, 0,0};
	static int moveY[]= {0,0,-1,1};
	static int w, h;
	static int hx, hy; //상근이의 위치
	static int fx, fy;
	static int time;
	static Queue<Node> queue1 = new LinkedList<Node>();
	static Queue<Node> queue2 = new LinkedList<Node>();
	static int visited[][];
	public static void escape(int hx, int hy, int fx, int fy) {
		queue1.add(new Node(hx,hy));
		queue2.add(new Node(fx,fy));
		Node human = queue1.poll();
		Node fire= queue2.poll();
		for (int i=0; i<4; i++) {
			int nextHX=human.x+moveX[i];
			int nextHY=human.y+moveY[i];//다음 상근이의 위치
			int nextFX=fire.x+moveX[i];
			int nextFY=fire.y+moveY[i];//다음 불의 위치
			
			if (nextHX>=0 && nextHX<w && nextHY>=0 && nextHY <h 
					&& map[nextHX][nextHY]=='.' && visited[nextHX][nextHY]==0) {
				
			}
			if (nextHX<0 && nextHX>w && nextHY>0 && nextHY >h) {
				return; //탈출
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		String input;
		
		
		for (int tc=0; tc<T; tc++) {
			Arrays.fill(map,0);
			time=0;
			input= br.readLine(); 
			StringTokenizer st= new StringTokenizer(input, " ");
			w= Integer.parseInt(st.nextToken()); //넓이 
			h= Integer.parseInt(st.nextToken()); //세로
			map= new char[h][w];
			for (int i=0; i<h; i++) {
				input= br.readLine();
				
				for (int j=0; j<w; j++) {
					map[i][j]=(input.charAt(j));
					if (map[i][j]=='@')
						{
						hx=j;
						hy=i;
						}
					else if (map[i][j]=='*') {
						fx=j;
						fy=i;
					}
				}
			}
			escape(hx,hy,fx,fy);
		}
		
	}

}
class Node {
	int x;
	int y;
	public Node(int x, int y) {
		this.x=x;
		this.y=y;
	}
}