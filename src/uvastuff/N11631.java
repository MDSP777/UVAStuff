package uvastuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class N11631 {
    public static void main(String[] args) throws IOException{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        while(true){
            ArrayList<Node> nodes = new ArrayList<>();
            ArrayList<Edge> edges = new ArrayList<>();
            int sum = 0;
            int mst = 0;
            String[] info = sc.readLine().split(" ");
            int nNodes = new Integer(info[0]);
            int nEdges = new Integer(info[1]);
            if(nNodes==0 && nEdges==0) break;
            for(int i=0; i<nNodes; i++){
                nodes.add(new Node(i));
            }
            boolean[] visit = new boolean[nNodes];
            
            for(int i=0; i<nEdges; i++){
                String[] asdf = sc.readLine().split(" ");
                int src = new Integer(asdf[0]);
                int dest = new Integer(asdf[1]);
                int weight = new Integer(asdf[2]);
                edges.add(new Edge(src, dest, weight));
                sum+=weight;
            }
            Collections.sort(edges);
            int nAdded = 0;
            ArrayList<Integer> prospect = new ArrayList<>();
            prospect.add(edges.get(0).src);
            visit[edges.get(0).src] = true;
            while(nAdded<nNodes){
                Edge best = Edge.MAX;
                for(Edge e: edges){
                    if(e.contains(prospect) && (!visit[e.src] || !visit[e.dest])){
                        best = e;
                        break;
                    }
                }
                edges.remove(best);
                if(best.equals(Edge.MAX)) break;
                if(!visit[best.src]) prospect.add(best.src);
                if(!visit[best.dest]) prospect.add(best.dest);
                visit[best.dest] = true;
                visit[best.src] = true;
                nAdded++;
                mst+=best.weight;
            }
            out.append((sum-mst)+"\n");
        }
        System.out.print(out);
    }

    private static class Edge implements Comparable<Edge>{
        private static Edge MAX = new Edge(-1, -1, Integer.MAX_VALUE);
        int src;
        int dest;
        int weight;
        
        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    
        public String toString(){
            return src + " " + dest + " " + weight;
        }
        
        public boolean contains(ArrayList<Integer> a){
            for(int cur: a){
                if(cur==src || cur==dest) return true;
            }
            return false;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.weight<o.weight) return -1;
            else if(this.weight>o.weight) return 1;
            return 0;
        }
    }
    
    static class Node {
        int val;
        ArrayList<Edge> edges;
        
        public Node(int val){
            this.val = val;
            edges = new ArrayList<>();
        }
        
    }
}
