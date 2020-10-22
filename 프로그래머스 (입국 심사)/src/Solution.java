
public class Solution {
	public static long solution(int n, int[] times) {
		long answer = 0;
		long left = 10;
		long right = 1000000000;
		
        
		while (left<=right) {
			long mid= (left+right)/2;
			long sum=0;
			for (int i=0; i<times.length; i++) {
				//System.out.println(sum);
				sum+=mid/times[i]; //시간동안 심사 마치는
				
			}
			
			//System.out.println(mid+ ","+ sum);
			
			if (sum>=n) {
				//answer=mid;
				if (sum==n)
				{
					answer=mid;
					
				}
				right=mid-1;
			}
			else {
				
				
				left=mid+1;
			}
			
		}
        System.out.println(answer);
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
		int times[] = {7,10};
		solution (n,times);
	}

}
