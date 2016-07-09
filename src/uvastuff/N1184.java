package uvastuff;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1184 {
//    static int[][] memo;
    static int[] visited;
    static Queue<Integer> q;
    static Vertex[] v;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            int nNodes = sc.nextInt();
            v = new Vertex[nNodes];
            visited = new int[nNodes];
            for(int i=0; i<nNodes; i++)
                visited[i] = -1;
            q = new LinkedList();
//            for(int i=0; i<nNodes; i++)
//                for(int j=0; j<nNodes; j++)
//                    memo[i][j] = -1;
            for(int i=0; i<nNodes; i++){
                int index = sc.nextInt();
                int nConn = sc.nextInt();
                int[] children = new int[nConn];
                for(int j=0; j<nConn; j++)
                    children[j] = sc.nextInt();
                v[index] = new Vertex(children);
            }
            int src = sc.nextInt();
            int dest = sc.nextInt();
            System.out.println(src+" "+dest+" "+(sssp(src, dest)-1));
            if(x<nC-1) System.out.println("");
        }

    }

    private static int sssp(int src, int dest) {
//        if(memo[src][dest]!=-1) return memo[src][dest];
//        visited[src][dest] = true;
//        int best = Integer.MAX_VALUE;
//        for(int i=0; i<memo.length; i++)
//            if(i!=src && !visited[i][dest])
//                best = Math.min(best, 1+sssp(i, dest));
//        memo[src][dest] = best;
//        return best;
        
        int dist = 0;
        q.add(src);
        visited[src] = dist;
        while(!q.isEmpty()){
            int tempSrc = q.remove();
            if(tempSrc==dest) return visited[tempSrc];
            for(int i=0; i<v[tempSrc].children.length; i++){
                int tempV = v[tempSrc].children[i];
                if(visited[tempV]==-1){
                    q.add(tempV);
                    visited[tempV] = visited[tempSrc]+1;
                }
            }
        }
        return dist;
    }
    
    static class Vertex{
        int[] children;
        
        public Vertex(int[] children){
            this.children = children;
        }
    }
}

