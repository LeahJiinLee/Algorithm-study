
public class Solution {
	 public static int solution(int n, int[] stations, int w) {
	        int answer = 0;
	        int location =1;
	        int idx=0;
	        while (location <=n) {
	        	if (idx<stations.length && location>=stations[idx]-w) {
	        		location=stations[idx]+w+1;
	        		idx++; // ������ ���� �ȿ� ������
	        	}
	        	else {
	        		location+=2*w+1; //������ ��ġ �ϰ� �� ���� Ž�� �������� �̵�
	        		System.out.println(location);
	        		answer++;
	        	}
	        }
	        
	        System.out.println(answer);
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 16;
		int stations[]= {9};
		int w=2;
		solution(n, stations, w);
	}

}
