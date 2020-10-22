import java.util.*; 
public class Solution {
    public static int solution(String s)
    {
    	//최대 길이 : 2~s의 길이
    	
       // int answer = 0;
        for (int len= s.length(); len>1; len--) {
        	for (int start=0; start+len<=s.length(); start++) {
        		boolean flag=true;
        		
        		for (int i=0; i<len/2; i++) {
        			if (s.charAt(start+i)!= s.charAt(start+len-i-1)){
        				flag=false;
        				break;
        			}
        		}
        		if (flag==true) {
        			System.out.println(len);
        			return len;
        		}
        	}
        		
        	
        }
        
        
        return 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "abba";
		solution(s);
		String s2= "abaabaaaaaaa";
		solution(s2);
	}

}
