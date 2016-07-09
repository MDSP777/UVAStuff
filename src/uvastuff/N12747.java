package uvastuff;

import java.util.Scanner;

public class N12747 {
    static int[][] memo;
    static int[] a;
    static int[] b;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] asdf = new char[200001][200001];
        System.out.println("hi");
        int nC = sc.nextInt();
        for(int x=1; x<=nC; x++){
            int size = sc.nextInt();
            memo = new int[size+1][size+1];
            for(int i=0; i<=size; i++)
                for(int j=0; j<=size; j++) memo[i][j] = -1;
            a = new int[size];
            b = new int[size];
            for(int i=0; i<size; i++) a[i] = sc.nextInt();
            for(int i=0; i<size; i++) b[i] = sc.nextInt();
            memo = new int[a.length+1][b.length+1];
            for(int i=0; i<=a.length; i++)
                for(int j=0; j<=b.length; j++) memo[i][j] = -1;
            System.out.println("Case "+x+": "+dp(a.length, b.length));
        }
    }
    
    private static int dp(int l1, int l2) {
        if(l1==0) return l2;
        if(l2==0) return l1;
        if(memo[l1][l2]!=-1) return memo[l1][l2];
        
        if(a[l1-1]==b[l2-1]){
            memo[l1][l2] = dp(l1-1, l2-1);
        } else {
            memo[l1][l2] = Math.min(dp(l1, l2-1), dp(l1-1, l2))+1;
        }
        
        return memo[l1][l2];
    }
}
