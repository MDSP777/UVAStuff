//package Aug13Training;
//
//import java.util.Scanner;
//
//public class N10891 {
//    static int nNums;
//    static int[] nums;
//    static int[][] memo;
//        
//    public static void main(String[] args){    
//        Scanner sc = new Scanner(System.in);
//        while(true){
//            nNums = sc.nextInt();
//            if(nNums==0) break;
//            for(int i=0; i<nNums; i++) nums[i] = sc.nextInt();
//            
//            memo = new int[nNums+1][nNums+1];
//            for(int i=0; i<=nNums; i++){
//                for(int j=0; j<=nNums; j++){
//                    memo[i][j] = -1;
//                }
//            }
//            System.out.println(dp(0, nNums));
//        }
//
//    }
//
//    private static int dp(int start, int end) {
//        if(start<0 || end>nNums){
//            return Integer.MIN_VALUE;
//        }
//        if(start==end) return 0;
//        if(memo[start][end]!=-1){
//            return memo[start][end];
//        }
//        if(start==end-1){
//            return nums[start];
//        }   
//    }
//}
