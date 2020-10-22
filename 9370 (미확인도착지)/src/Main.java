import java.util.*;
import java.io.*;
class Node {
	int destination;
	int value;
	public Node(int destination, int value) {
		this.destination=destination;
		this.value= value;
	}
}

public class Main {
	static ArrayList<Node> graph [];
	static int n,m,t; //교차로, 도로, 목적지 후보
	static int s,g,h;

	static int dist[];
	static int visited[];
	static  ArrayList<Integer> ans_list;
	public static void search () {
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node node1, Node node2) {
				if (node1.value>node2.value) {
					return 1;
					
				}
				else {
					return -1;
				}
			}
		});
		dist[s]= 0;//출발점
		pq.add(new Node(s,0));
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			if (visited[current.destination]==1) continue;
			visited[current.destination]=1;
			
			for (Node node: graph[current.destination]) {
			
				//if (visited[node.destination]!=1)
				if (visited[node.destination]!=1&& dist[node.destination]>node.value +dist[current.destination]) {
					dist[node.destination]= node.value +dist[current.destination];
					pq.add(new Node(node.destination, dist[node.destination]));
				}
				
			}
		}
//		for (int i=1; i<=n ;i++) {
//			System.out.println(dist[i]);
//		}
		for (int i=0; i<ans_list.size(); i++) {
			int temp= ans_list.get(i);
			
			if ((dist[temp]%2)==1) {
				System.out.print(temp+ " ");
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for (int tc=0; tc<T; tc++) {
			String input = br.readLine();
			StringTokenizer st= new StringTokenizer(input);
			n= Integer.parseInt(st.nextToken());
			m= Integer.parseInt(st.nextToken());
			t= Integer.parseInt(st.nextToken());
			graph= new ArrayList[n+1];
			dist= new int [n+1];
			visited= new int [n+1];
			ans_list= new ArrayList<Integer>();
			Arrays.fill(dist,100000000);
			for (int i=0; i<=n; i++) {
				graph[i]=new ArrayList<Node>();
			}
			input= br.readLine();
			st= new StringTokenizer(input);
			s= Integer.parseInt(st.nextToken());//시작점
			g= Integer.parseInt(st.nextToken());// g-h 구간
			h= Integer.parseInt(st.nextToken());
			for (int i=0; i<m; i++) {
				input= br.readLine();
				st= new StringTokenizer(input);
				int node1= Integer.parseInt(st.nextToken());
				int node2= Integer.parseInt(st.nextToken());
				int value= Integer.parseInt(st.nextToken());
				if ((node1==g && node2==h) || (node1==h && node2==g)) {
					graph[node1].add(new Node(node2, value*2-1));
					graph[node2].add(new Node(node1, value*2-1));
				}
				else {
					graph[node1].add(new Node(node2, value*2));
					graph[node2].add(new Node(node1, value*2));
				}
				
			}
			for (int i=0; i<t; i++) {
				 
				ans_list.add(Integer.parseInt(br.readLine()));
			}
			Collections.sort(ans_list);
			search();
		}
	}

}
