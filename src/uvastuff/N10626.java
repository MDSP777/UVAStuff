package uvastuff;

import java.util.Scanner;

public class N10626 {
    static int[] memo = new int[151];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            for(int ii=1; ii<151; ii++) memo[ii] = -1;
            int coke = sc.nextInt();
            int none = sc.nextInt();
            int nfive = sc.nextInt();
            int nten = sc.nextInt();
            System.out.println(dp(coke, none, nfive, nten));
        }
    }
    
    public static int dp(int coke, int none, int nfive, int nten){
        if(memo[coke]!=-1) return memo[coke];
        int ans = Integer.MAX_VALUE;
        if(coke==1){
            if(nten>0) ans = 1;
            else if(nfive>1) ans = 2;
            else if(nfive>0&&none>2) ans = 4;
            else if(none>7) ans = 8;
            memo[1] = ans;
            return memo[1];
        }
        ans = Math.min(ans, dp(coke-1, none+2, nfive, nten-1)+1);
        ans = Math.min(ans, dp(coke-1, none+2, nfive-2, nten)+2);
        ans = Math.min(ans, dp(coke-1, none-3, nfive-1, nten)+4);
        ans = Math.min(ans, dp(coke-1, none-8, nfive, nten)+8);
        memo[coke] = ans;
        return ans;
    }
}
