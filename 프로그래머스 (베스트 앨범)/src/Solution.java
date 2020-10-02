import java.util.*;
class Genre{
	String name;
	int play;
	public Genre(String name, int play) {
		this.name=name;
		this.play=play;
	}
}
class Music {
	int num;
	int play;
	public Music (int num, int play) {
		this.num=num;
		this.play=play;
	}
}
public class Solution {
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        HashMap<String, ArrayList<Music>> hs= new HashMap<String, ArrayList<Music>>();
        HashMap<String, Integer> map= new HashMap<String, Integer>();
        ArrayList<Genre> list= new ArrayList<Genre>();
        ArrayList<Integer> result= new ArrayList<Integer>();
        for (int i=0; i<genres.length; i++) {
        	hs.put(genres[i], new ArrayList<Music>());
        	map.put(genres[i],0);
        }

        for (int i=0; i<plays.length; i++) {
        	Music music= new Music (i, plays[i]);
        	hs.get(genres[i]).add(music);
        	map.put(genres[i],map.get(genres[i])+plays[i]);
        }
        
        Comparator<Music> cp = new Comparator<Music>() {
        	public int compare(Music m1, Music m2) {
        		if (m1.play<m2.play) {
    				return 1;
    			}
    			else if (m1.play==m2.play) {
    				if (m1.num>m2.num) {
    					return 1;
    				}
    				else {
    					return -1;
    				}
    			}
    			else {
    				return -1;
    			}
        	}
        };
       for (String s: hs.keySet()) {
    	   Collections.sort(hs.get(s), cp);
       }
      
       for (String s: map.keySet()) {
    	 list.add(new Genre(s,map.get(s)));
       }
       Collections.sort(list, new Comparator<Genre>() {
    	   public int compare (Genre g1, Genre g2) {
    		   if(g1.play<g2.play) {
    			   return 1;
    		   }
    		   else {
    			   return -1;
    		   }
    	   }
       });
       
       for (int i=0; i<list.size(); i++) {
    	   String temp= list.get(i).name;
    	   if (hs.get(temp).size()==1)
    	   {
    		   result.add(hs.get(temp).get(0).num);
    	   }
    	   else {
    		   for (int j=0; j<2; j++) {
    			   result.add(hs.get(temp).get(j).num);
    		   }
    	   }
       }
       answer= new int [result.size()];
       for (int i=0; i<result.size(); i++) {
    	   answer[i]=result.get(i);
    	   System.out.println(answer[i]);
       }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] genres = {"classic", "pop", "classic", "classic", "pop"};
		int [] plays= {500, 600, 150, 800, 2500};
		solution (genres, plays);
	}

}
