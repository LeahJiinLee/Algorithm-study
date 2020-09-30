import java.io.*;
import java.util.*;

public class Main {
	static int n;
	//static int m;
	static int indegree[];
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> result ;
	static void sort () {
		Queue<Integer> que= new LinkedList<Integer>();
		result= new ArrayList<Integer>(); 
		//System.out.println(indegree[5]);
					
		for (int i=1; i<indegree.length; i++) {
			if (indegree[i]==0) {
				
				que.add(i);
			}
		}
		if (que.size()>1) {
			System.out.println("?");
			return;
		}
		while (!que.isEmpty()) {
			int temp= que.poll();
			result.add(temp);
			for (int i=0; i<list[temp].size(); i++) {
				if (--indegree[list[temp].get(i)]==0) {
					que.add(list[temp].get(i));
				}
			}
		}
		if (result.size()!=n) {
			System.out.print("IMPOSSIBLE");
		}
		else {
			for (int i=0; i<result.size(); i++)
			System.out.print(result.get(i)+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		
		
		StringTokenizer st;
		for (int tc=0; tc<T; tc++) {
			n= Integer.parseInt(br.readLine());//°¹¼ö
			list= new ArrayList[n+1];
			int temp[]= new int[n+1];
			indegree= new int[n+1];
			Arrays.fill(indegree, 0);
			String input= br.readLine();//ÆÀ ¼øÀ§
			st= new StringTokenizer(input);
			for (int i=1; i<=n; i++) {
				list[i]= new ArrayList<Integer>();
				temp[i]=Integer.parseInt(st.nextToken());
			}
			for (int i=1; i<=n-1; i++) {
				for (int j=i+1; j<=n; j++) {
					list[temp[i]].add(temp[j]);
					indegree[temp[j]]++;
				}
				
			}
			
			int m= Integer.parseInt(br.readLine());//¹Ù²ï ½Ö °¹¼ö
			
			if (m!=0)
			{
			for (int i=0; i<m; i++) {
				input= br.readLine();
				st= new StringTokenizer(input);
				int first= Integer.parseInt(st.nextToken());
				int second= Integer.parseInt(st.nextToken());
				if (list[first].indexOf(second)!=-1) {
					list[first].remove(list[first].indexOf(second));
					list[second].add(first);
					indegree[second]--;
					indegree[first]++;
				}
				else if(list[second].indexOf(first)!=-1){
					list[second].remove(list[second].indexOf(first));
					list[first].add(second);
					indegree[second]++;
					indegree[first]--;
				}

				
			}
		}
		
				sort();
			
			
			
			
		}
	}

}
