import java.util.*;
import java.io.*;
class Node {
	int parent;
	ArrayList<Integer> child;
	int level;
	
}
public class Main {
	static Node family[]= new Node[101];
	static int answer;
	static void solve (int person, int person2) {
		
		int x=person;
		
		ArrayList<Integer> [] arr= new ArrayList[2];
		Queue<Integer>que= new LinkedList<Integer>();
		
		for (int i=0; i<2;i++) {
			arr[i]= new ArrayList<Integer>();
		}
		
		while (true) {//node1의 부모탐색
			if (family[x].parent==0)break;
			arr[0].add(family[x].parent);
			x= family[x].parent;
			
		}
		x= person2;
		while (true) {//node2 부모탐색
			if (family[x].parent==0) break;
			arr[1].add(family[x].parent);
			x= family[x].parent;
		}

		if (arr[0].contains(person2)) {
			answer=arr[0].indexOf(person2)+1;
		}
		else if (arr[1].contains(person)) {
			answer= arr[1].indexOf(person)+1;
		}
		else {
		boolean flag= false;
		for (int i=0; i<arr[0].size(); i++) {
			
			for (int j=0; j<arr[1].size(); j++) {
				
				if (arr[0].get(i)==arr[1].get(j)) {
					
					answer=i+j+2;
					flag=true;
					break;
				}
			}
			if (flag==true) 
				{
				break;
				
				}
	
		}
		if (flag==false) answer=-1;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int m= Integer.parseInt(br.readLine()); //총인원
		String input= br.readLine(); //누구누구? 
		StringTokenizer st= new StringTokenizer(input);
		int person= Integer.parseInt(st.nextToken());
		int person2= Integer.parseInt(st.nextToken());
		int e= Integer.parseInt(br.readLine());
		for (int i=0; i<family.length; i++) {
			family[i]= new Node();
			family[i].parent=0;
			family[i].child= new ArrayList<Integer>();
			family[i].level=0;
		}
		for (int i=0; i<e; i++) {
			input= br.readLine();
			st= new StringTokenizer(input);
			int node1= Integer.parseInt(st.nextToken());
			int node2=Integer.parseInt(st.nextToken());
			family[node1].child.add(node2);
			family[node2].parent=node1;
		}
		
		solve(person,person2);
		System.out.println(answer);
		

	}

}
