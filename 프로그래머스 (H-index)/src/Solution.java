import java.util.Arrays;
import java.util.Collections;

public class Solution {
	public static int solution(int[] citations) {
        int answer = 0;
        Integer arr[]= new Integer[citations.length];
        for (int i=0; i<citations.length; i++) {
        	arr[i]=citations[i];
        }
        
        Arrays.sort(arr,Collections.reverseOrder());
        int idx=0;
        while (idx<citations.length) {
        	if (idx>=arr[idx]) {
        		
        		break;
        	}
        	idx++;
        }
        answer=idx;
        System.out.println(answer);
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] citations = {10,50,100};
		solution(citations);
	}

}
