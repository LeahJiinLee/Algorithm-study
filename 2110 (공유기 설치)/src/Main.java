import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st= new StringTokenizer(input);
		int N= Integer.parseInt(st.nextToken());
		int C= Integer.parseInt(st.nextToken());
		int house []= new int [N];
		for (int i=0; i<N; i++) {
			house[i]= Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		int left=1; //간격 시작
		int right= house[N-1]- house[0]; //최대 간격
		int dist=0;
		int answer=0;
		while (left <=right) {
			int mid = (left + right) /2;
			int start= house[0];
			int count=1;//공유기 수
			
			for (int i=1; i<N; i++) {
				dist=house[i]-start;
				if (mid<=dist) {
					count++;
					start=house[i];
				}
			}
			if (count>=C) {
				answer=mid;
				left=mid+1;
			}
			else {
				right=mid-1;
			}
		}
		System.out.println(answer);
	}

}
