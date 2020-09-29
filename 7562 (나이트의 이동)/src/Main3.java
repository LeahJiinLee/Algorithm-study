import java.util.*;
import java.io.*;
class Location {
	int x;
	int y;
	int level;
	public Location (int x, int y, int level) {
		this.x= x;
		this.y=y;
		this.level= level;
	}
}
public class Main3 {
	

	static int L;//체스판 크기
	//static int board[][];
	static int visited[][];
	//static Stack<Location> stk= new Stack<Location>();
	static Queue<Location> que = new LinkedList<Location>();
	static int dir_x [] = {-1, -2,-2, -1, 1, 2, 2, 1};
	static int dir_y []= {-2, -1,1, 2, 2, 1,-1, -2};
	static int count=0;
	static int search (int x, int y, int endX, int endY) {
		//stk.push(new Location(x,y)); 
		que.add(new Location(x,y,0));
		while (!que.isEmpty()) {
			Location current =que.poll();
			//if (current.x==endX && current.y==endY) return;
			//count++;
			//System.out.println("curent:"+ current.x+ ","+ current.y+ ","+ current.level);
			for (int i=0; i<dir_x.length; i++) {
				int nextX= current.x+dir_x[i];
				int nextY= current.y+dir_y[i];
				int level= current.level+1;
				if (nextX==endX && nextY==endY) {
					//System.out.println(nextX+", "+ nextY);
					return level;
				}
				if (nextX>=0 && nextX<L && nextY>=0 && nextY<L && visited[nextX][nextY]==0) {
					//System.out.println(nextX+", "+ nextY+ ","+ level);
					visited[nextX][nextY]=1;
					que.add(new Location (nextX, nextY,level));
					//count++;
					
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int tc =Integer.parseInt(br.readLine()); //테케 갯수
		for (int i=0; i<tc; i++) {
			que.clear();
			count=0;
			L= Integer.parseInt(br.readLine()); //체스판 크기
			
			//board = new int [L][L];
			visited = new int [L][L];
			for (int row[]: visited) {
				Arrays.fill(row,  0);
			} //초기화시킴
			String input= br.readLine();
			StringTokenizer st= new StringTokenizer(input);
			int startX= Integer.parseInt(st.nextToken()); 
			int startY= Integer.parseInt(st.nextToken());
			input = br.readLine();
			st= new StringTokenizer(input);
			
			int endX= Integer.parseInt(st.nextToken()); 
			int endY= Integer.parseInt(st.nextToken()); 
			
			if (startX==endX && startY==endY) System.out.println(0);
			else {
			visited[startX][startY]=1;
			System.out.println(search(startX, startY, endX, endY));
			}
			//System.out.println(count);
		}
	}

}
