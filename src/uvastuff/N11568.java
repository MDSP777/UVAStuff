package uvastuff;

import java.util.Scanner;

public class N11568 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        for(int x=0; x<nC; x++){
            int nMM = 0;
            int nFF = 0;
            String[] in = sc.nextLine().split(" ");
            for(int i=0; i<in.length; i++)
                if(in[i].equals("MM")) nMM++;
                else if(in[i].equals("FF")) nFF++;
            if(nMM == nFF && in.length>1) System.out.println("LOOP");
            else System.out.println("NO LOOP");
        }
    }
}
