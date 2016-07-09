
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Edit {
    static int[][] memo;
    static String w1;
    static String w2;
    static ArrayList<String> ansArrayList;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            w1 = sc.next();
            w2 = sc.next();
            memo = new int[w1.length()+1][w2.length()+1];
            
            for(int i=0; i<=w2.length(); i++){
                memo[0][i] = i;
            }
            for(int i=0; i<=w1.length(); i++){
                memo[i][0] = i;
            }
            
            for(int i=1; i<=w1.length(); i++)
                for(int j=1; j<=w2.length(); j++){
                    memo[i][j] = -1;
                }
            
            System.out.println(dp(w1.length(), w2.length()));
            printMemo();
            System.out.println(backtrack());
            printMissChariOutput();
        }

    }
    
    static int dp(int i, int j){
        if(memo[i][j]!=-1) return memo[i][j];
        if(i==0) return j;
        if(j==0) return i;
        int ans = dp(i, j-1)+1;
        if(dp(i-1, j)+1<ans){
            ans = dp(i-1, j)+1;
        } 
        int ans2 = dp(i-1, j-1);
        if(w1.charAt(i-1)!=w2.charAt(j-1)){
            ans2+=2;
        }
        if(ans2<ans){
            ans = ans2;
        }
        
        memo[i][j] = ans;
        return ans;
    }
    
    static void printMemo(){
        for(int i=0; i<memo.length; i++){
            for(int j=0; j<memo[0].length; j++){
                System.out.print(memo[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    static String backtrack(){
        int cur = memo[w1.length()][w2.length()];
        int i = w1.length();
        int j = w2.length();
        String ans = "";
        ansArrayList = new ArrayList();
        while(cur!=0){
            int up;
            int left;
            int diag;
            
            if(i>0) up = memo[i-1][j];
            else up = Integer.MAX_VALUE;
            
            if(j>0) left = memo[i][j-1];
            else left = Integer.MAX_VALUE;
            
            if(i>0 && j>0) diag = memo[i-1][j-1];
            else diag = Integer.MAX_VALUE;
            int min = min(up, left, diag);
            if(min<cur){
                if(min == diag){
                    ansArrayList.add("SWAP "+w1.charAt(i-1)+" with "+w2.charAt(j-1)+" at "+(i-1));
                } else if(min == left){
                    ansArrayList.add("INSERT "+w2.charAt(j-1)+" at "+(j-1));
                } else if(min == up){
                    ansArrayList.add("DELETE "+w1.charAt(i-1)+" at "+(i-1));
                }
            }
            cur = min;
            if(min == diag){
                i--;
                j--;
            } else if(min == left){
                j--;
            } else {
                i--;
            }
        }
        Collections.reverse(ansArrayList);
        for(String a: ansArrayList){
            ans+=a+"\n";
        }
        return ans;
    }
    
    static int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }

    private static void printMissChariOutput() {
        String word1 = w1;
        String word2 = w1;
        int offInsert = 0;
        int offDelete = 0;
        for(String a: ansArrayList){
            String[] split = a.split(" ");
            String oper = split[0];
            int index = Integer.parseInt(split[split.length-1]);
            if(oper.equals("SWAP")){
                word2 = word2.substring(0, index+offDelete)+split[split.length-3]+word2.substring(index+1+offDelete);
            } else if(oper.equals("INSERT")){
                word1 = word1.substring(0, index+offInsert)+"-"+word1.substring(index+offInsert);
                word2 = word2.substring(0, index+offInsert)+split[split.length-3]+word2.substring(index+offInsert);
                offDelete++;
            } else if(oper.equals("DELETE")){
                word1 = word1.substring(0, index+offDelete)+split[split.length-3]+word1.substring(index+1+offDelete);
                word2 = word2.substring(0, index+offDelete)+"-"+word2.substring(index+1+offDelete);
                offInsert++;
            }
            
        }
        System.out.println(word1);
        System.out.println(word2);
    }
}
