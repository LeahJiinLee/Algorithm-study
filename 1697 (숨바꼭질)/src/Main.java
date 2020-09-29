import java.io.*;
import java.util.*;
class Location {
	int curr;
	int time;
	public Location (int curr, int time) {
		this.curr=curr;
		this.time=time;
	}
}
public class Main {
	static int N, K;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		N= Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		Queue<Location> q= new LinkedList<Location>();
		int visited[]= new int [100001];
		Arrays.fill(visited, 0);
		int answer=100001;
		q.add(new Location(N,0)); //현재 있는 지점에서 시작
		visited[N]=1;
		while (!q.isEmpty()) {
			Location temp = q.poll();
			if (temp.curr==K) {
				answer=Math.min(answer,temp.time);
				//break;
			}
			if (temp.curr-1>=0 && visited[temp.curr-1]==0) {
				q.add(new Location(temp.curr-1,temp.time+1));
				visited[temp.curr-1]=1;
			}
			if (temp.curr+1<=100000&& visited[temp.curr+1]==0) {
				q.add(new Location(temp.curr+1, temp.time+1));
				visited[temp.curr+1]=1;
			}
			if (temp.curr*2<=100000&& visited[temp.curr*2]==0) {
				q.add(new Location(temp.curr*2, temp.time+1));
			}
		}
		System.out.print(answer);
	}

}
