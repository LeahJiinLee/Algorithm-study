import java.util.*;
import java.io.*;



public class Main2
{
    static int N;
    static int M;
    static int V;
    static Boolean[] vi;
    static ArrayList<Integer>[] node;
    public static void dfs(int V)
    {
        Arrays.fill(vi,false);
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(V);
        
        while(!stk.isEmpty())
        {
            int temp = stk.pop();
            if(vi[temp] == true)
            {
                continue;
            }
            vi[temp] = true;
            System.out.print(temp +" ");
            for(int i=0; i<node[temp].size(); i++)
            {
                if(vi[node[temp].get(i)] == false)
                {
                    stk.push(node[temp].get(i));
                }
            }
        }
        System.out.println();
    }
    public static void bfs(int V)
    {
        Arrays.fill(vi, false);
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(V);
        
        while(!q.isEmpty())
        {
            int temp =  q.poll();
            if(vi[temp] == true)
            {
                continue;
            }
            vi[temp] = true;
            System.out.print(temp + " ");
            for(int i = 0; i<node[temp].size(); i++)
            {
                if(vi[node[temp].get(i)]==false)
                {
                    q.add(node[temp].get(i));
                }
            }
        }
    }
    
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nmv = br.readLine();
        StringTokenizer st = new StringTokenizer(nmv);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        node = new ArrayList[N+1];
        vi = new Boolean[N+1];
        for(int i=0; i<=N; i++)
        {
            node[i] = new ArrayList<Integer>();
        }
        for(int i=0; i< M; i++)
        {
            String str = br.readLine();
            StringTokenizer st1 = new StringTokenizer(str);
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            node[a].add(b);
            node[b].add(a);
            
        }
        
        for(int i=1;i<=N; i++)
        {
            Collections.sort(node[i], Comparator.reverseOrder());
        }
        dfs(V);
        
        for(int i=1;i<=N; i++)
        {
            Collections.sort(node[i]);
        }
        bfs(V);
        
        
            
    }
}