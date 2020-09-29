import java.io.*;
import java.util.*;
class Info {
	int num;
	String str;
	public Info (int num, String str) {
		this.num=num;
		this.str=str;
	}
}
public class Main {
	static int visited[]= new int[100001];
	//static String reg []= {"D", "S", "L", "R"};
	public static void bfs (int A, int B) {
	Queue<Info> q= new LinkedList<Info>();
	q.add(new Info(A,""));
	visited[A]=1;
	while (!q.isEmpty()) {
		Info temp = q.poll();
		//System.out.println(temp.num+","+ temp.str);
		if (temp.num==B) {
			System.out.println(temp.str);
			break;
		}
		int next= temp.num;
		String next_str=temp.str;
		if (temp.num*2>9999) {
			next=(temp.num*2)%10000;
			
		}
		else {
			next=temp.num*2;
		}
		if (visited[next]==0) {
			next_str= temp.str+"D";
			q.add(new Info(next,next_str));
			visited[next]=1;
		}
		if (temp.num==0) {
			next=9999;
		}
		else {
			next=temp.num-1;
		}
		if (visited[next]==0) {
			next_str=temp.str+"S";
			q.add(new Info(next, next_str));
			visited[next]=1;
		}
		next= (temp.num%1000)*10 +temp.num/1000;
		if (visited[next]==0) {
			next_str=temp.str+"L";
			q.add(new Info (next, next_str));
			visited[next]=1;
		}
		next = (temp.num%10)*1000+temp.num/10;
		if (visited[next]==0) {
			next_str=temp.str+"R";
			q.add(new Info(next, next_str));
			visited[next]=1;
		}
	
	}
	
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());//Å×ÄÉ °¹¼ö
		int A,B;
		for (int tc=0; tc<T; tc++) {
			Arrays.fill(visited, 0);
			String input = br.readLine();
			StringTokenizer st= new StringTokenizer(input);
			A= Integer.parseInt(st.nextToken());
			B= Integer.parseInt(st.nextToken());
			bfs(A,B);
		}
		
	}

}
