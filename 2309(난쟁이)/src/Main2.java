import java.util.*;
import java.io.*;

public class Main2 {

	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int visited[] = new int[9];
	static int heights[] = new int[9];
	static int count = 0;
	static int flag = 0;

	static void search(int n, int count, int sum) {
		if (count == 7) {
			if (sum == 100) {

				for (int i = 0; i < 9; i++) {
					if (visited[i] == 1) {
						list.add(heights[i]);
					}
				}
				Collections.sort(list);
				flag = 1;
			}
			return;
		}

		for (int idx = n + 1; idx < 9; idx++) {
			if (flag == 1)
				break;
			if (visited[idx] == 0) {
				visited[idx] = 1;
				search(idx, count + 1, sum + heights[idx]);
				visited[idx] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			heights[i] = Integer.parseInt(br.readLine()); // 키 입력 받음
		}
		for (int i = 0; i < 9; i++) {
			if (flag == 1)
				break;
			visited[i] = 1;
			search(i, 1, heights[i]);
			visited[i] = 0;

		}
//		visited[0]=1;
//		search(0,1,heights[0]);
//		visited[0]=0;
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
