import java.io.*;
import java.util.*;
class Location {
	int x;
	int y;
	public Location (int x, int y) {
		this.x=x;
		this.y=y;
	}
}
public class Main {
	static int R,C,T; 
	static int room[][]; //-1�� ����û����, �������� ����
	static int room2[][];
	static int dir_x[]= {-1,1,0,0};
	static int dir_y[]= {0,0,-1,1};
	static void dust () {//���� Ȯ��
		Queue<Location> q= new LinkedList<Location>();
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (room[i][j]>=5) {
					q.add(new Location (i,j)); //�̼����� q�� �ֱ�
				}
			}
		}
		
		while (!q.isEmpty()) {
			int count=0; //������ Ƚ��
			Location curr= q.poll();
			for (int i=0; i<4; i++) { //������� �ȱ�
				int next_x= curr.x+dir_x[i];
				int next_y= curr.y+dir_y[i];
				
				if (next_x<0 || next_x>=R || next_y<0 ||next_y>=C) continue;
				if ( room[next_x][next_y]!=-1) //��û �ƴϸ�
				{
					count++; //
					room[next_x][next_y]+=room2[curr.x][curr.y]/5;
					//room[curr.x][curr.y]-=room[curr.x][curr.y]/5;
				}
			}
			room[curr.x][curr.y]-=(room2[curr.x][curr.y]/5)*count;
			
		}
		
	}
	static void rotate1(int up) {//���κ� rotate
		Queue<Integer> q= new LinkedList<Integer>();
		for (int i=1; i<C; i++) {
			q.add(room[up][i]);
		}
		for (int i=up-1; i>=0; i--) {
			q.add(room[i][C-1]);
			
		}
		for (int i=C-2; i>=0; i--) {
			q.add(room[0][i]);
		}
		for (int i=1; i<=up-1; i++) {
			q.add(room[i][0]);
		}
		
		room[up][1]=0;
		for (int i=2; i<C; i++) {
			room[up][i]=q.poll();
		}
		for (int i= up-1; i>=0; i--) {
			room[i][C-1]=q.poll();
		
		}
		for (int i=C-2; i>=0; i--) {
			room[0][i]=q.poll();
		}
		for (int i=1; i<=up-1;i++) {
			room[i][0]=q.poll();
		}
	}
	static void rotate2(int down) {//�Ʒ��κ� rotate
		Queue<Integer> q= new LinkedList<Integer>();
		for (int i=1; i<C; i++) {
			q.add(room[down][i]);
			
		}
		for (int i=down+1; i<R; i++) {
			q.add(room[i][C-1]);
		}
		for (int i=C-2; i>=0; i--) {
			q.add(room[R-1][i]);
		}
		for (int i= R-2; i>=down+1; i--) {
			q.add(room[i][0]);
		}
		
		room[down][1]=0;
		for (int i=2; i<=C-1; i++) {
			room[down][i]=q.poll();
		}
		for (int i=down+1; i<R; i++) {
			room[i][C-1]=q.poll();
		}
		for (int i=C-2; i>=0; i--) {
			room[R-1][i]=q.poll();
		}
		for (int i=R-2; i>=down+1; i--) {
			room[i][0]=q.poll();
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		T= Integer.parseInt(st.nextToken());
		int answer=0;
		room= new int [R][C];
		room2=new int [R][C];
		ArrayList<Integer> air= new ArrayList<Integer>();
		
		for (int i=0; i<R; i++) {
			input= br.readLine();
			st= new StringTokenizer(input);
			for (int j=0; j<C; j++) {
				room[i][j]= Integer.parseInt(st.nextToken());
				if (room[i][j]==-1) {
					air.add(i);
				}
				room2[i][j]= room[i][j];
			}
		}
		for (int i=0; i<T; i++) {
			dust();
			
	
			rotate1(air.get(0));
			rotate2(air.get(1));
			for (int r=0; r<R; r++) {
				for (int c=0; c<C;c++) {
					room2[r][c]=room[r][c];
					
				}
		
			}
			
		}
		
		for (int r=0; r<R; r++) {
			for (int c=0; c<C;c++) {
				if (room[r][c]!=-1)
				answer+=room[r][c];
			}
		}
		System.out.println(answer);
	}

}
