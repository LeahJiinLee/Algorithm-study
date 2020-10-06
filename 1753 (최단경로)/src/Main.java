import java.io.*;
import java.util.*;
class Node{
	int destination;
	int value;
	public Node (int destination, int value) {
		this.destination=destination;
		this.value=value;
	}
}
public class Main {
	static int distance [];
	static int visited[];
	static ArrayList<Node> [] graph;
	static int start;
	public static void shortest() {
		PriorityQueue<Node> pq= new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node node1, Node node2) {
				if (node1.value>node2.value) {
					return 1;
				}
				else return -1;
			}
		});
		distance[start]=0;
		pq.add(new Node(start,0));
		while (!pq.isEmpty()) {
			int current = pq.poll().destination;
			if(visited[current]==1) continue;
			visited[current]=1;
			
			for (Node node: graph[current]) {
				if (distance[node.destination]> distance[current]+node.value) {
					distance[node.destination]=distance[current]+node.value;
					
				}
				pq.add(new Node(node.destination, distance[node.destination]));
			}
			
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		int V= Integer.parseInt(st.nextToken());
		int E= Integer.parseInt(st.nextToken());
		start= Integer.parseInt(br.readLine());
		graph= new ArrayList[V+1];
		for (int i=1; i<=V; i++) {
			graph[i]= new ArrayList<Node>();
		}
		visited= new int [V+1];
		distance= new int [V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		
		for (int i=0; i<E; i++) {
			//u,v,w ют╥б
			input= br.readLine();
			st=new StringTokenizer(input);
			int u= Integer.parseInt(st.nextToken());
			int v= Integer.parseInt(st.nextToken());
			int w= Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v,w));
		}
		shortest();

		distance[start]=0;
		for (int i=1; i<=V; i++) {
			if (distance[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
				
			}
			else {
				System.out.println(distance[i]);
			}
		}
	}

}
