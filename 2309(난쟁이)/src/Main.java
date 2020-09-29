import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList <Integer> list = new ArrayList<Integer> ();
		int total=0;
		int result=0;
		
		for (int i=0; i<9; i++) {
			
			list.add(Integer.parseInt(bf.readLine()));
			total+=list.get(i);
		}
		for (int i=0; i<list.size()-1; i++) {
			for (int j=i+1; j<list.size();j++) {
				result=list.get(i) + list.get(j);
				if (total-result==100) {
					list.remove (i);
					list.remove(j-1);//i가 삭제됐으니까 인덱스 하나 줄음
				}
			}
		}
		Collections.sort(list);
		
	
	for (int i=0; i<list.size(); i++) {
		System.out.println(list.get(i));
	}

}
}