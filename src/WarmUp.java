
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WarmUp {
    public static void main(String[] args){
//        System.out.println(polyAsc("5 3 2 -1"));
//        System.out.println(polyAsc("-4 -1 2"));
//        System.out.println(polyDesc("5 3 2 -1"));
//        System.out.println(polyDesc("-4 -1 2"));
//        System.out.println(polyAsc("12 0 4 0 2"));
//        System.out.println(polyDesc("12 0 4 0 2"));
        
        System.out.println(polyAsc("2 1 -1"));
        System.out.println(polyAsc("1 1 0 1"));

    }
    
    public static String polyAsc(String str){
        String[] split = str.split(" ");
        Term[] terms = new Term[split.length];
        int topIndex = split.length-1;
        String out = "";
        for(int i=0; i<terms.length; i++){
            terms[i] = new Term(topIndex--, new Integer(split[i]));
            out+=terms[i];
        }
        if(out.startsWith("+")){
            out = out.substring(1, out.length());
        }
        return out;
    }
    
    public static String polyDesc(String str){
        String[] split = str.split(" ");
        List<String> splitList = Arrays.asList(split);
        Collections.reverse(splitList);
        for(int i=0; i<split.length; i++){
            split[i] = splitList.get(i);
        }
        Term[] terms = new Term[split.length];
        int topIndex = split.length-1;
        String out = "";
        for(int i=0; i<terms.length; i++){
            terms[i] = new Term(topIndex--, new Integer(split[i]));
            out+=terms[i];
        }
        if(out.startsWith("+")){
            out = out.substring(1, out.length());
        }
        return out;
    }
    
    private static class Term{
        int pow;
        int coeff;
        
        public Term(int p, int c){
            pow = p;
            coeff = c;
        }
        
        public String toString(){
            String out = "";
            if(coeff==0){
                return "";
            }
            if(pow==0){
                if(coeff>=1){
                    return "+"+coeff;
                } else{
                    return coeff+"";
                }
            }
            if(coeff==-1){
                out = "-";
            } else if(coeff==1){
                out = "+";
            } else if(coeff>1){
                out = "+"+coeff;
            } else{
                out = coeff+"";
            }
            if(pow>=1) {
                out += "x";
            }
            if(pow>=2){
                out+= "^"+pow;
            }
            return out;
        }
    }
    
    private Term multiply(Term t1, Term t2){
        return new Term(t1.pow+t2.pow, t1.coeff*t2.coeff);
    }
}
