import java.util.ArrayList;
import java.util.Queue;
 public class Classroom{
    static  class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
           this.src = s;
           this.dest = d;       
           this.wt = w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge (0,2,2));

        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,0));
        
        graph[2].add(new Edge(2, 0,2));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,-1));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,-1));
    }
     
      // Breadth First Function
      public static void dfs(ArrayList<Edge> graph[], int V, int start, boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        // boolean vis[] = new boolean[V];
         q.add(start);

         while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] == false){
                System.out.println(curr+ "");
                vis[curr] = true;

                for(int i=0; i<graph[curr].size(); i++){
                      Edge e =graph[curr].get(i);
                      if(vis[e.dest] == false)
                      dfs( graph,e.dest,i, vis);
                }
            }
         }
      }
    public static void main (String args []){
        int V = 6; 
         
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);


        boolean vis[] = new boolean[V];
        for(int i=0; i<V; i++ ){
          if(vis[i] == false){
            dfs(graph, V , i,vis);
          }
        }
        System.out.println();
        // Print 2's neighbours 
        // for(int i=0; i<graph[1].size(); i++){
        //     Edge e =  graph[1].get(i);
        //     System.out.println(e.dest+"," +e.wt);
        // }
    }
}