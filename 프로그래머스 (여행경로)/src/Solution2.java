import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Stack;
import java.util.Arrays;


public class Solution2 {
	static int visited[];
	static ArrayList<String> list= new ArrayList<String>();
	static String route="";
	static void dfs(String[][] tickets, String dest, int cnt) {
		route+=dest+",";
		if (cnt==tickets.length) {
			list.add(route);
			return;
		}
		for (int i=0; i<tickets.length; i++) {
			String from = tickets[i][0];
			String to=tickets[i][1];
			if (from.equals(dest) && visited[i]!=1) {
				visited[i]=1;
				dfs(tickets, to, cnt+1);
				visited[i]=0;
				route=route.substring(0,route.length()-4);
			}
		}
		
	}
	 public static String[] solution(String[][] tickets){
		 
		  
		  //Arrays.fill(visited,0);
		 for (int i=0; i<tickets.length; i++) {
			 visited= new int[tickets.length];
			 String dep= tickets[i][0];
			 String dest= tickets[i][1];
			 if (dep.equals("ICN")) {
				 route=dep+",";
				 visited[i]=1;
				 dfs(tickets,dest, 1);
			 }
		 }
		 Collections.sort(list);
//		 for (int i=0; i<list.size(); i++) {
//			 System.out.println(list.get(i));
//		 }
		 
		 String []answer= list.get(0).split(",");
	        return answer;
	 }

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
//		String tickets[][]= 
//				{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String tickets2[][]= {{"ICN", "SFO"},{"ICN","ATL"},{"SFO","ATL"},
				{"ATL","ICN"},{"ATL","SFO"}};
		
		//solution(tickets);
		solution (tickets2);
	}

}
