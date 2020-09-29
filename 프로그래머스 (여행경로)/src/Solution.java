import java.util.*;
class Info {
	//String depart;
	String arrival;
	int used;
	public Info (String arrival, int used) {
		//this.depart=depart;
		this.arrival=arrival;
		this.used=used;
	}
}
public class Solution {
	
	 public static String[] solution(String[][] tickets){
		  String[] answer;
		  Stack<String> stk= new Stack<String>();
		  HashMap<String, ArrayList<Info>> flight= new HashMap<String, ArrayList<Info>>();
		  ArrayList<String> iti= new ArrayList<String>();
		  for (int i=0; i<tickets.length; i++) {
			  flight.put(tickets[i][0],new ArrayList<Info>());
			  
		  }
		  for (int i=0; i<tickets.length; i++) {
			  flight.get(tickets[i][0]).add(new Info(tickets[i][1],0));
		  }
		 // System.out.println(flight.get("HND").get(0).arrival);
		  stk.push("ICN");
		  while (!stk.isEmpty()) {
			  String current= stk.pop();
			 // System.out.println(current);
			  iti.add(current);
			  if (flight.containsKey(current)==false) break;
			  ArrayList<Info> list= flight.get(current);
			  if (list.size()>1) {
			  Collections.sort(list, new Comparator<Info>() {
				  public int compare(Info info1, Info info2) {
					  return info2.arrival.compareTo(info1.arrival);
				  }
			  });
			  }
			
			  for (int i=0; i<list.size();i++) {
				  if (list.get(i).used==0) {//사용되지 않은 티켓이라면
					  stk.push(list.get(i).arrival);
					  list.get(i).used=1;
				  }
			  }
		  }
		  answer=new String[iti.size()];
		  for (int i=0; i<iti.size();i++) {
			 
			  answer[i]=iti.get(i);
			  System.out.println(answer[i]);
		  }
	        return answer;
	 }

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		String tickets[][]= 
				{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String tickets2[][]= {{"ICN", "SFO"},{"ICN","ATL"},{"SFO","ATL"},
				{"ATL","ICN"},{"ATL","SFO"}};
		
		solution(tickets);
		solution (tickets2);
	}

}
