package uvastuff;

import java.util.Scanner;

public class N12442 {
    static boolean[] visited;
    static boolean[] memo;
    static int[] longest;
    static int[] forwardTo;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder("");
        int nC = sc.nextInt();
        for(int x=1; x<=nC; x++){
            int bestL = 0;
            int bestAns = 0;
            int nPeople = sc.nextInt();
            visited = new boolean[nPeople+1];
            memo = new boolean[nPeople+1];
            longest = new int[nPeople+1];
            forwardTo = new int[nPeople+1];
            for(int i=0; i<nPeople; i++)
                forwardTo[sc.nextInt()] = sc.nextInt();
            for(int i=1; i<=nPeople; i++){
                if(!memo[i]){
                    visited = new boolean[nPeople+1];
                    int cur = getLength(i);
                    if(cur>bestL){
                        bestL = cur;
                        bestAns = i;
                    }
                }
            }
            out.append("Case "+x+": "+bestAns+"\n");
        }
        System.out.print(out);
    }
    

    static int getLength(int src) {
        int curL = 0;
        while(true){
            if(visited[src]) return curL;
            visited[src] = true;
            memo[src] = true;
            src = forwardTo[src];
            curL++;
        }
    }
}
