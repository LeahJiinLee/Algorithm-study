import java.io.*;
import java.util.*;
public class Main2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sb= new StringBuilder(Integer.toString(1));
		System.out.println(sb.substring(0,sb.length()-1));
	
		sb= new StringBuilder(Integer.toString(1000));
		if (sb.length()>1) {
			String last= sb.substring(0,sb.length()-1);
			sb.delete(0, sb.length()-1);
			sb.append(last);
		}
		System.out.println(Integer.parseInt(sb.toString()));
	}

}
