package Aug7Training;

import java.util.HashMap;
import java.util.Scanner;

public class Scrabble {
    static HashMap<String, Integer> letters;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        letters = new HashMap<>();
        letters.put("A", 1);
        letters.put("B", 3);
        letters.put("C", 3);
        letters.put("D", 2);
        letters.put("E", 1);
        letters.put("F", 4);
        letters.put("G", 2);
        letters.put("H", 4);
        letters.put("I", 1);
        letters.put("J", 8);
        letters.put("K", 5);
        letters.put("L", 1);
        letters.put("M", 3);
        letters.put("N", 1);
        letters.put("O", 1);
        letters.put("P", 3);
        letters.put("Q", 10);
        letters.put("R", 1);
        letters.put("S", 1);
        letters.put("T", 1);
        letters.put("U", 1);
        letters.put("V", 4);
        letters.put("W", 4);
        letters.put("X", 8);
        letters.put("Y", 4);
        letters.put("Z", 10);
        
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            System.out.println(getPointVal(sc.next()));
        }
    }

    private static long getPointVal(String str) {
        int mult = 1;
        int nextMul = 1;
        int l = str.length();
        int total = 0;
        for(int i=0; i<l; i++){
            char c = str.charAt(i);
            if(c=='2' || c=='3'){
                nextMul = new Integer(c+"");
                continue;
            }
            if(c=='@'){
                mult*=2;
                continue;
            }
            if(c=='#'){
                mult*=3;
                continue;
            }
            if(c=='-'){
                nextMul = 1;
            }
            else{
                int pointVal = letters.get(c+"");
                if(nextMul!=1){
                    pointVal*=nextMul;
                    nextMul = 1;
                }
                total+=pointVal;
            }
        }
        return total*mult;
    }
}
