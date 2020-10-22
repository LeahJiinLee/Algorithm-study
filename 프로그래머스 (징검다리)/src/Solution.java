import java.util.*;
public class Solution {
	public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int left=0;
        int right=distance;
        
        int dist=0;
        while (left<=right) {
        	int mid=(left+right)/2;
        	int start=0;
        	int count=0; //제거한 집수 
        	for (int i=0; i<rocks.length; i++) {
        		dist=rocks[i]-start;
        		if (mid>dist) { //범위 내에 있은까 제거
        			count++;
        		}
        		else {
        			start= rocks[i]; 
        			
        		}
        			
        		
        	}
        	if (distance-start<mid) count++;
        	if (count<=n) {
        		answer=mid;
        		
        		left= mid+1; //넓힘
        	}
        	else {
        		right= mid-1;//간격을 줄인다
        	}
        	
        }
        //System.out.println(answer);
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int distance= 25;
		int [] rocks= { 2, 14, 11, 21, 17};
		int n=2;
		solution (distance, rocks, n);
	}

}
