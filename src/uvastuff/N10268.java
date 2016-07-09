package uvastuff;

import java.util.Scanner;

public class N10268 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            long x = sc.nextLong();
            sc.nextLine();
            long total = 0;
            String n = sc.nextLine();
            String[] split = n.split(" ");
            for(int i=0; i<split.length; i++){
                long asdf = Long.parseLong(split[i]);
                if(split.length-i-2<=0)
                    total += asdf*(split.length-i-1);
                else total += asdf*myPow(x, split.length-i-2)*(split.length-i-1);
            }
            System.out.println(total);
        }while(sc.hasNext());

    }
    
    public static long myPow(long x, int n){
        long total = 1;
        for(int i=0; i<n; i++) total*=x;
        return total;
    }
}
