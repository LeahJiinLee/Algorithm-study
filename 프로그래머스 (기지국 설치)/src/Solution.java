
public class Solution {
	 public static int solution(int n, int[] stations, int w) {
	        int answer = 0;
	        int location =1;
	        int idx=0;
	        while (location <=n) {
	        	if (idx<stations.length && location>=stations[idx]-w) {
	        		location=stations[idx]+w+1;
	        		idx++; // 기지국 영역 안에 있으면
	        	}
	        	else {
	        		location+=2*w+1; //기지국 설치 하고 그 다음 탐색 지점으로 이동
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
