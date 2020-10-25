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

	static int M,N,K;
	
	static int map[][];
	static int visited[][];
	static int dir_x[] = {-1,1,0,0};
	static int dir_y[] = {0,0,-1,1};
	static int count;
	static Queue<Node> queue = new LinkedList<Node>();
	static List <Integer> list = new ArrayList<Integer> (); //넓이 저장용
	public static void search(int x, int y) {
		visited[x][y]=1;
		queue.add(new Node(x,y));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i=0; i<4; i++) {
				int nextX=node.x+dir_x[i];
				int nextY=node.y+dir_y[i];
				if (nextX<M && nextX>=0 && nextY<N && nextY>=0
						&& map[nextX][nextY]==0
						&& visited[nextX][nextY]==0) {
					count+=1;
					queue.add(new Node(nextX, nextY));
					visited[nextX][nextY]=1;
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input, " ");
		M= Integer.parseInt(st.nextToken()); //세로 (행)
		N= Integer.parseInt(st.nextToken()); //가로 (열)
		K= Integer.parseInt(st.nextToken()); //직사각형 갯수
		map= new int [M][N];
		visited = new int [M][N];
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				map[i][j]=0;
			}
		}
		for (int i=0; i<K; i++) {  //직사각형 갯수 만큼 꼭지점 입력받아야함
			input= br.readLine();
			st= new StringTokenizer(input," ");
			int x1= Integer.parseInt(st.nextToken());
			int y1= Integer.parseInt(st.nextToken()); //왼쪽 아래꼭지점
			int x2= Integer.parseInt(st.nextToken());
			int y2= Integer.parseInt(st.nextToken()); //오른쪽 위 꼭지점
			for (int p=M-1-(y2-1); p<=M-1-y1; p++) {
				for (int q=x1; q<=x2-1; q++) {
					map[p][q]=1;
				}
			}
		} //영역 저장
		/*for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}*/
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j]==0&&visited[i][j]==0) {
					count=1;
					search(i,j);
					list.add(count); //면적을 저장
				}
			}
		}
		list.sort(new Comparator<Integer>() {
            public int compare (Integer arg0, Integer arg1) {
                return arg0.compareTo(arg1);
            }
        });
	
	System.out.println(list.size());
	for(int i=0; i<list.size(); i++) {
		System.out.print(list.get(i)+ " ");
	}
	}

}
