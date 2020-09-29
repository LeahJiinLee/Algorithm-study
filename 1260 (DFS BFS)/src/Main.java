import java.io.*;
import java.util.*;
public class Main {
	static int N; //정점개수
	static int M;
	static int V;
	static ArrayList<Integer> [] tree;
	static int visited[];
	public static void dfs(int V) {
		Arrays.fill(visited,0);
		Stack<Integer> stk = new Stack<Integer>();
		
		stk.push(V);
		
		while (!stk.isEmpty()) {
			int temp= stk.pop();
			if (visited[temp]==1) {
				continue;
			}
			visited[temp]=1;
			System.out.print(temp+" ");
		for (int i=0; i<tree[temp].size();i++) {
			if (visited[tree[temp].get(i)]==0) {
				stk.push(tree[temp].get(i));
			}
		}
		}
		//System.out.println();
	}
	public static void dfs2(int V) {
		visited[V]=1;
		System.out.print(V+" ");
		for (int i=0; i<tree[V].size(); i++) {
			if (visited[tree[V].get(i)]==0) {
				
				
				dfs2(tree[V].get(i));
			}
		}
	}
	public static void bfs(int V) {
		Arrays.fill(visited,0);
		Queue<Integer> q= new LinkedList<Integer>();
		
			q.add(V);
		
		while (!q.isEmpty()) {
			int temp= q.poll();
			if (visited[temp]==1) {
				continue;
			}
			visited[temp]=1;
			System.out.print(temp+" ");
		for (int i=0; i<tree[temp].size();i++) {
			if (visited[tree[temp].get(i)]==0) {
				q.add(tree[temp].get(i));
			}
		}
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer (input);
		N=Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		V= Integer.parseInt(st.nextToken());
		tree= new ArrayList[N+1];
		visited= new int[N+1];
		
		for (int i=0; i<=N; i++) {
			tree[i]= new ArrayList<Integer>();
		}
		for (int i=0; i<M; i++) {
			input= br.readLine();
			st= new StringTokenizer(input);
			int temp= Integer.parseInt(st.nextToken());
			int temp2= Integer.parseInt(st.nextToken());
			tree[temp].add(temp2);
			tree[temp2].add(temp);
		}
		
		for (int i=1; i<=N; i++) {
			Collections.sort(tree[i], Collections.reverseOrder());
		}
		
		dfs(V);
		System.out.println();
		for (int i=1; i<=N; i++) {
			Collections.sort(tree[i]);
		}
		bfs(V);
	}

}
