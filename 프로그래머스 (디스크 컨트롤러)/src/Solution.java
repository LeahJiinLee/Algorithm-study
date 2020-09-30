import java.util.*;
class Job{
	int arrival;
	int duration;
	public Job (int x, int y) {
		this.arrival = x;
		this.duration=y;
	}
}
public class Solution {
	 public static int solution(int[][] jobs) {
		 int answer=0;
		 PriorityQueue<Job> controller = new PriorityQueue<Job>(new Comparator<Job> () {
			public int compare(Job job1, Job job2) {
				if (job1.duration>job2.duration) {
					return 1;
				}
				else {
					return -1;
				}
			}
		 });
		 
		 Queue<Job> que = new LinkedList<Job>();
		 
		 //controller.add(new Job(jobs[0][0], jobs[0][1]));
		 for (int i=0; i<jobs.length; i++) {
			 que.add(new Job(jobs[i][0], jobs[i][1]));
		 }
		 int idx=0;
		 int now=que.peek().arrival;
		 while (idx<jobs.length) {
			 
			 while (!que.isEmpty()&&que.peek().arrival<=now) {
				 controller.add(que.poll());
			 }
			 if (!controller.isEmpty()) {
				 Job current= controller.poll();
				 System.out.println(current.duration);
				 now+=current.duration;
				 answer+=now-current.arrival;
				 
				 idx++;
			 }
			 else {
				 now++;
			 }
		 }
		 
		 answer/=jobs.length;
		 System.out.println(answer);
		 return answer;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 int [][]jobs= {{0,3},{1,9}, {2,6}};
	 solution(jobs);
	}

}
