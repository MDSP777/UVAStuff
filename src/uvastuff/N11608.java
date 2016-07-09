package uvastuff;

import java.util.Scanner;

public class N11608 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int add = sc.nextInt();
        int t = 1;
        while(add>=0){
            System.out.println("Case "+t+++":");
            int[] probs = new int[13];
            probs[0] = add;
            for(int i=1; i<13; i++)
                probs[i] = sc.nextInt()+probs[i-1];
            for(int i=0; i<12; i++)
                if(sc.nextInt()>probs[i]) System.out.println("No problem. :(");
                else System.out.println("No problem! :D");
            add = sc.nextInt();
        }
    }
}
