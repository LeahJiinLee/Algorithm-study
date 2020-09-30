
public class Solution {
	public static int solution(int sticker[]) {
        if(sticker.length==1){
            return sticker[0];
        }
        else if(sticker.length==2){
            return Math.max(sticker[0], sticker[1]);
        }
        int DP[]= new int[sticker.length-1];
		int DP2[]= new int[sticker.length];
		DP[0]=sticker[0];
		DP[1]=sticker[0];
		DP2[0]=0;
		DP2[1]=sticker[1];
		for (int i=2; i<sticker.length-1; i++) {
			DP[i]=Math.max(DP[i-2]+sticker[i],DP[i-1] );
		}
		for (int i=2; i<sticker.length; i++) {
			DP2[i]=Math.max(DP2[i-2]+sticker[i], DP2[i-1] );
		}
		
		return Math.max(DP[DP.length-1], DP2[DP2.length-1]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sticker[]= {1,3,2,5,4};
		int answer= solution(sticker);
		System.out.println(answer);
	}

}
