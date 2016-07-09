package uvastuff;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N12160 {
    static boolean[] visited;
    static int[] answers;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while(true){
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if(a==0&&b==0&&c==0) break;
            visited = new boolean[10000];
            answers = new int[10000];
            for(int i=0; i<10000; i++)
                answers[i] = -1;
            int[] buttons = new int[c];
            for(int i=0; i<c; i++) buttons[i] = sc.nextInt();
            int ans=0;
            //ans = bfs(a, b, buttons);
            if(ans==Integer.MAX_VALUE) System.out.println("Case "+t+++": Permanently Locked");
            else System.out.println("Case "+t+++": "+ans);
        }
    }
    
    /*public static int bfs(int cur, int goal, int[] buttons){
           sobrang sabaw ko na grabe 
           hopefully I can still fix this 
           I don't think this works
           this probably doesn't work
           need to study bfs implementation 
        
        Queue<Integer> q = new LinkedList();
        int total = 0;
        if(cur==goal) return 0;
        for(int i=0; i<buttons.length; i++){
            q.add((cur+buttons[i])%10000);
            visited[(cur+buttons[i])%10000] = true;
        }
        while(q.size()!=0){
            int head = q.remove();
            for(int i=0; i<buttons.length; i++){
                if(!visited[((cur+head)%10000+buttons[i])%10000]){
                    q.add(((cur+head)%10000+buttons[i])%10000);
                    visited[((cur+head)%10000+buttons[i])%10000] = true;
                    total++;
                }
            }
        }
    }*/ 
}
