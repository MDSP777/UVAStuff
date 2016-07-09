package uvastuff;

import java.util.ArrayList;
import java.util.Scanner;

public class N11157 {
    static ArrayList<Rock> rocks;
    static long[][] memo;
    static long d;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int asdf=1; asdf<=nC; asdf++){
            int n = sc.nextInt();
            d = sc.nextLong();
            sc.nextLine();
            rocks = new ArrayList<>();
            for(int i=0; i<n; i++){
                String[] r = sc.next().split("-");
                if(r[0].equals("S")){
                    rocks.add(new Rock(Long.parseLong(r[1]), true));
                } else {
                    rocks.add(new Rock(Long.parseLong(r[1]), false));
                }
            }
            for(int i=n-1; i>=0; i--){
                rocks.add(rocks.get(i));
            }
            
            
        }

    }
    
    static class Rock {
        long d;
        boolean isSmall;
        
        public Rock(long d, boolean isSmall){
            this.d = d;
            this.isSmall = isSmall;
        }
        
        public String toString(){
            return (isSmall ? "S" : "B")+"-"+d;
        }
    }
}
