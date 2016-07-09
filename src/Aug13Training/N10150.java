package Aug13Training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class N10150 {
    static ArrayList<String> dictionary;
    static Queue<Node> q;
    static HashMap<String, Node> map = new HashMap<String, Node>();
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Node>[] words = new ArrayList[17];
        for(int i=1; i<17; i++){
            words[i] = new ArrayList<Node>();
        }
        
        dictionary = new ArrayList<>();
        while(true){
            String in = sc.nextLine();
            if(in.equals("")) break;
            dictionary.add(in);
            Node node = new Node(in);
            map.put(in, node);
            words[in.length()].add(node);
            for(Node n: words[in.length()]){
                if(diff1(in, n.val)){
                    n.neighbors.add(node);
                    node.neighbors.add(n);
                }
            }
        }
        
        
        
        do{
            String src = sc.next();
            String dest = sc.next();
            if(!map.containsKey(src) || !map.containsKey(dest)){
                System.out.println("No solution.");
                if(sc.hasNext()) System.out.println();
                continue;
            }
            Node sNode = map.get(src);
            Node dNode = map.get(dest);
            
            Set<String> visited = new HashSet<>();
            HashMap<String, String> parents = new HashMap<>();
            q = new LinkedList<>();
            q.add(sNode);
            while(!q.isEmpty()){
                Node newNode = q.poll();
                if(newNode.equals(dNode)){
                    break;
                } else {
                    for(Node neighbor: newNode.neighbors){
                        if(!visited.contains(neighbor.val)){
                            visited.add(neighbor.val);
                            q.add(neighbor);
                            parents.put(neighbor.val, newNode.val);
                        }
                    }
                }
            }
            if(!parents.containsKey(dest)){
                System.out.println("No solution.");
            }
            else{
                ArrayList<String> ans = new ArrayList<>();
                String s = dest;
                while(!s.equals(src)){
                    ans.add(s);
                    s = parents.get(s);
                }
                ans.add(src);

                Collections.reverse(ans);
                for(String str: ans){
                    System.out.println(str);
                }
            }
            if(sc.hasNext()) System.out.println();
        }while(sc.hasNext());
    }
    
    private static boolean diff1(String a, String b) {
        int count = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)) count++;
        }
        return count==1;
    }
    
    static class Node{
        String val;
        ArrayList<Node> neighbors;
        
        public Node(String v){
            val = v;
            neighbors = new ArrayList<>();
        }
    }
}
