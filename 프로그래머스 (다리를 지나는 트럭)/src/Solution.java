import java.util.*;
public class Solution {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer=0;
		Queue<Integer> q= new LinkedList<Integer>(); // 다리 위 트럭
		int time[]= new int [truck_weights.length];
		//int curr_weight=0;//다리 위 트럭들의 무게
		int curr_tr=0;//현재 몇번째 트럭
		while (true) {
			if (!q.isEmpty() && time[q.peek()]==answer) {
				weight+=truck_weights[q.poll()];// 다지나간 트럭 뺌
			}
			if (curr_tr<truck_weights.length && truck_weights[curr_tr]<=weight) {
				q.add(curr_tr);
				time[curr_tr]=answer+bridge_length;
				weight-=truck_weights[curr_tr];
				curr_tr++;
			}
			
			answer++;
			if (q.isEmpty()) break;
		}
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length=2;
		int weight=10;
		int[] truck_weights = {7,4,5,6};
		int result= solution (bridge_length, weight, truck_weights);
		System.out.println(result);
		
		
	}

}
