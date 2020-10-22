import java.util.*;
class Node {
	int dest;
	int val;
	public Node (int dest, int val) {
		this.dest=dest;
		this.val=val;
	}
}
public class Solution {
	static ArrayList<Node> [] graph;
	static int visited[];
	static int answer=Integer.MAX_VALUE;
	public static void dfs(int start, int count) {
		//int answer=Integer.MAX_VALUE;
		visited[start]=1;
		System.out.print(start+",");
		int flag=0;
		for (int i=0; i<visited.length; i++) {
			if (visited[i]!=1) {
				flag=1;
				break;
			}
		}
		if (flag==0) {
			answer= count;
			System.out.println(answer);
			
			return;
		}
		for (int i=0; i<graph[start].size(); i++) {
			if(visited[graph[start].get(i).dest]==0) {
				visited[graph[start].get(i).dest]=1;
				dfs(graph[start].get(i).dest, count+graph[start].get(i).val);
			}
			
		}
		
	}
	 public static int solution(int n, int[][] costs) {
	          
	        int result=Integer.MAX_VALUE;
	        graph= new ArrayList[n];
	        visited= new int[n];
	        for (int i=0; i<n;i++) {
	        	graph[i]= new ArrayList<Node>();
	        }
	        for (int i=0; i<costs.length; i++) {
        	int node1=costs[i][0];
        	int node2= costs[i][1];
        	int val= costs[i][2];
        	graph[node1].add(new Node(node2, val));
        	graph[node2].add(new Node(node1, val));
        }
	        for (int i=0; i<graph.length; i++) {
	        	Arrays.fill(visited, 0);
	        	dfs(i,0);
	        	result=Math.min(answer,result);
	        	//System.out.println(answer);
	        }
	        System.out.println(result);
	       
	       return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int [][] costs= {{0,1,1,}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		solution(n, costs);
	}

}
