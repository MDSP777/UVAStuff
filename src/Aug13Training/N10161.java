package Aug13Training;

import java.util.Scanner;

public class N10161 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            long n = sc.nextLong();
            if(n==0) break;
            
            double ceil = Math.ceil(Math.sqrt(n));
            double floor = ceil - 1;
            double ave = (ceil*ceil + floor*floor + 1)/2;
            double col = (ceil-Math.abs(n-ave));
            double row = ceil;
            if((n>ave && ((long)ceil)%2==0) || (n<ave && ((long)ceil)%2==1)){
                row = col;
                col = ceil;
            }
            System.out.println(((long)col)+" "+((long)row));
        }

    }
}
