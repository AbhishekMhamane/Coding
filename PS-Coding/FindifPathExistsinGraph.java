import java.util.ArrayList;

public class FindifPathExistsinGraph {

  public static boolean validPath(int n, int[][] edges, int source, int destination){

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    int visited[] = new int[n];
    visited[source] = 1;

    createGraph(n,edges,adj);

    return findValidPath(adj,visited,source,destination);
  }

  public static boolean findValidPath(ArrayList<ArrayList<Integer>> adj,int visited[],int source, int destination){

    visited[source] = 1;

    if(source == destination){
      return true;
    }

    ArrayList<Integer> list = adj.get(source);

    for(Integer i: list){
      if(visited[i] != 1){
        if(findValidPath(adj,visited,i,destination)){
          return true;
        }
      }
    }

    return false;
  }

  public static void createGraph(int n, int[][] edges, ArrayList<ArrayList<Integer>> adj){
    for(int i=0;i<n;i++){
      adj.add(new ArrayList<>());
    }

    for(int i=0;i<edges.length;i++){
      addEdge(adj,edges[i][0],edges[i][1]);
    }
  }

  public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
    adj.get(u).add(v);
    adj.get(v).add(u);
  }

  public static void main(String[] args) {

    int n = 6;
    int[][] edges = {{0, 1},{0, 2}, {3, 5},{5,4},{4,3}};
    int source = 0;
    int destination = 2;
    System.out.println(validPath(n, edges, source, destination));
  }
}
