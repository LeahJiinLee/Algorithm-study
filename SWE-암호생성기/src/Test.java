
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String temp= Integer.toBinaryString(1);
		StringBuilder sbr = new StringBuilder();
        for (int p=0; p<5-temp.length() ; p++) {
            sbr.append("0");
        }
        temp = sbr.toString()+temp;
		System.out.println(temp);
	}

}
