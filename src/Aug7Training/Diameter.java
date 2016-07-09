package Aug7Training;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Diameter {
    static int nVerts;
    
    public static void main(String[] args){
        int nC = 1;
        Scanner sc = new Scanner(System.in);
        while(true){
            nVerts = sc.nextInt();
            if(nVerts==0) break;
            int[][] adj = new int[nVerts][nVerts];
            for(int i=1; i<nVerts; i++){
                int src = sc.nextInt()-1;
                int dest = sc.nextInt()-1;
                adj[src][dest] = adj[dest][src] = 1;
            }
            
            
            System.out.println("Tree #"+nC+++": "+diameter(adj));
        }

    }
    
    private static int diameter(int[][] adj){
        int result = 0;
        for(int i=0; i<nVerts; i++){
            result = Math.max(result, BFS(adj, i));
        }
        return result;
    }

    private static int BFS(int[][] adj, int start) {
        Queue<Node> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int dist = 0;
        q.add(new Node(start, 0));
        while(!q.isEmpty()){
            Node e = q.poll();
            visited.add(e.n);
            dist = Math.max(dist, e.length);
            for(int i=0; i<nVerts; i++){
                if(i!=e.n && adj[e.n][i]!=0 && !visited.contains(i)){
                    q.add(new Node(i, e.length+1));
                }
            }
        }
        return dist;
    }
    
    static class Node{
        int n;
        int length;
        
        public Node(int n, int length){
            this.n = n;
            this.length = length;
        }
    }
}
