import java.util.*;

public class Solution {
	static int n;
	static int visited [];
	
	static int pro (int computers[][]) {
		Queue<Integer> que = new LinkedList<Integer>();
		ArrayList<Integer> graph[]= new ArrayList[n];
		int answer=0;
		for (int i=0; i<graph.length; i++) {
			graph[i]=new ArrayList<Integer>();
			
		}
		for (int i=0; i<computers.length; i++) {
			for (int j=0; j<computers[i].length; j++) {
				if (computers[i][j]==1)
				graph[i].add(j);
			}
		}
		for (int i=0; i<n; i++) {
			if (graph[i].size()==0) {
				continue;
			}
			if (visited[i]==1) {
				continue;
			}
			que.add(i);
			visited[i]=1;//방문 표시
			while (!que.isEmpty()) {
				int curr= que.poll();
				for (int count=0; count<graph[curr].size(); count++) {
					if (visited[graph[curr].get(count)]==0) {
						que.add(graph[curr].get(count));
						visited[graph[curr].get(count)]=1;
					}
				}
			}
			answer++;
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n=3;
		int computers [][]= {{1,1,0}, {1,1,0}, {0,0,1}};
		visited = new int [n];
		Arrays.fill(visited, 0);
		int result= pro(computers);
		System.out.println(result);
	}

}
