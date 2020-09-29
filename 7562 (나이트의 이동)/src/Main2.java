import java.io.*;
import java.util.*;

class Node { //좌표
	int x;
	int y;
	public Node (int x, int y) {
		this.x = x;
		this.y= y;
	}
}
public class Main2 {
	static int TC=0; //test case
	static int L;
	static int map [][];
	static int count;
	static int fromX, fromY, toX, toY;
	static Stack<Node> stack = new Stack <Node>();
	static int dir_x[] = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int dir_y[] = {-1, 1, -2, 2, -2, 2, -1, 1};

	public static void search (int fromX, int fromY) {
		stack.push(new Node(fromX, fromY));
		if (!stack.isEmpty()) {
			Node current=stack.pop();
			if (current.x==toX && current.y==toY) return ;
			else {
				for (int i=0; i<dir_x.length; i++) {
					int next_x= current.x+dir_x[i];
					int next_y= current.y+dir_y[i];
					if (next_x==toX && next_y==toY) {
						count++;
						return;
					}
					if (next_x<L && next_x>=0 && next_y<L && next_y>=0
							&& map[next_x][next_y]==0) {
						count++;
						map[next_x][next_y]=1; //방문 표시
						stack.push(new Node(next_x, next_y));
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		String input;
		StringTokenizer st;
		TC= Integer.parseInt(br.readLine());
		
		for (int i=0; i<TC; i++) {
			count=0;
			stack.clear(); //각 테케마다 초기화
			L=Integer.parseInt(br.readLine());
			map= new int[L][L]; //체스판 생성
			for (int j=0; j<L; j++) {
				for (int k=0; k<L; k++) {
					map[j][k]=0; //초기화 시킴
				}
			}
			for (int p=0; p<2; p++) {
				input= br.readLine();
				st= new StringTokenizer(input);
				if (p==0) {
					fromX= Integer.parseInt(st.nextToken());
					fromY= Integer.parseInt(st.nextToken());
				}
				else if (p==1) {
					toX= Integer.parseInt(st.nextToken());
					toY= Integer.parseInt(st.nextToken());
				}
			}
			map[fromX][fromY]=1;
			search (fromX, fromY);
			System.out.println(count);
		}
		
	}

}
