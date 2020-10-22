package 순열조합;
import java.util.*;
public class Combination {
	static int []arr= {1,2,3,4,5};
	static void makeComb (int r, int temp[], int start, int current) {//조합
		if (r==current) {
			System.out.println(Arrays.toString(temp));
		}
		else {
			for (int i=start; i<arr.length; i++) {
				temp[current]=arr[i];
				makeComb(r,temp, i+1, current+1);
			}
		}
	}
	static void makeOverLabComb(int r, int temp[], int start, int current) {//중복조합
		if (r==current) {
			System.out.println(Arrays.toString(temp));
		}
		else {
			for (int i=start; i<arr.length; i++) {
				temp[current]=arr[i];
				makeOverLabComb(r,temp, i, current+1);
			}
		}
		
	}
	static void permutation (int r, int temp[],  int current, int []visited) {//순열
		if (r==current) {
			System.out.println(Arrays.toString(temp));
		}
		else {
			for (int i=0; i<arr.length; i++) {
				if (visited[i]==0) {
					visited[i]=1;
					temp[current]=arr[i];
					permutation(r,temp, current+1, visited);
					visited[i]=0;
				}
				
			}
		}
	}
	static void makeOverLabPermu(int r, int [] temp,int current) {//중복 순열
		if (r==current) {
			System.out.println(Arrays.toString(temp));
		}
		else {
			for (int i=0; i<arr.length; i++) {
				temp[current]=arr[i];
				makeOverLabPermu(r, temp, current+1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result[]=new int[3];
		int visited[]= new int[5];
		Arrays.fill(visited, 0);
		permutation(3,result,0,visited);
	}

}
