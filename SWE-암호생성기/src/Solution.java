import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		int tc; 
		Queue<Integer> q;
		for (int test_case=0; test_case<10; test_case++) {
			
			tc = Integer.parseInt(br.readLine());
			q=  new LinkedList<Integer>();
			q.clear();
			String input = br.readLine();
			StringTokenizer st= new StringTokenizer(input);
			for(int i=0; i<8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
				
			}
			
			int temp=9999999;
			while (true) {
				for (int j=1; j<=5 ; j++) {
					temp= q.poll();//ť���� ����
					temp-=j;
					if (temp<=0) { //0���� �۰ų� �������� 
						q.add(0); //�ڷ� ������ ����
						break;
					}
					
				}
				
				q.add(temp);
				if (temp<=0) {
				System.out.print("#"+ tc+ " ");
				while (!q.isEmpty()) {
					System.out.print(q.poll()+ " ");
				}
				System.out.println();
				break;
				}
				else {
					continue;
				}
			}
			
		}
	}

}
