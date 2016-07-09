package uvastuff;

import java.util.Scanner;

public class N10140 {
    static boolean[] prime;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        prime = new boolean[50000];
        for(int i=1; i<50000; i++) prime[i] = true;
        for(int i=2; i<50000; i++){
            if(prime[i]){
                for(int j=2*i; j<50000; j+=i){
                    prime[j] = false;
                }
            }
        }
        
        do{
            int start = sc.nextInt();
            int end = sc.nextInt();
            
            int minDist = Integer.MAX_VALUE;
            int maxDist = Integer.MIN_VALUE;
            
            for(int i=start; i<=end; i++) 
                if(isPrime(i)){
                
                }
        }while(sc.hasNext());
    }

    private static boolean isPrime(int in) {
        if(in<50000) return prime[in];
        for(int i=2; i<Math.sqrt(in)+1; i++){
            
        }
        return true;
    }
}
