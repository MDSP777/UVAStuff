package Aug7Training;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Poly {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = 1;
        while(true){
            int nTermsT1 = sc.nextInt();
            int nTermsT2 = sc.nextInt();
            if(nTermsT1==0 && nTermsT2==0) break;
            
            Term[] t1Terms = new Term[nTermsT1+1];
            Term[] t2Terms = new Term[nTermsT2+1];
            
            for(int i=0; i<=nTermsT1; i++)
                t1Terms[i] = new Term(i, sc.nextInt());
            for(int i=0; i<=nTermsT2; i++)
                t2Terms[i] = new Term(i, sc.nextInt());
            
//            Term[] result = new Term[nTermsT1*nTermsT2+1];
            Term[] result = new Term[1];
            result[0] = new Term(0, 0);
            for(int i=0; i<=nTermsT1; i++){
                Term[] prod = new Term[1];
                prod[0] = new Term(0, 1);
                
                for(int j=0; j<t1Terms[i].pow; j++){
                    prod = multiplyPoly(t2Terms, prod);
                }
                for(int j=0; j<prod.length; j++){
                    prod[j].coeff *= t1Terms[i].coeff;
                }
                
                result = addPoly(prod, result);
            }
            
            System.out.println("Data set "+nC+++": "+polyDesc(result));
        }

    }
    
    public static String polyDesc(Term[] terms){
        List<Term> termList = Arrays.asList(terms);
        Collections.reverse(termList);
        for(int i=0; i<terms.length; i++)
            terms[i] = termList.get(i);
        String out = "";
        for(int i=0; i<terms.length; i++){
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
    
    private static Term multiply(Term t1, Term t2){
        return new Term(t1.pow+t2.pow, t1.coeff*t2.coeff);
    }
    
    // assume same power
    private static Term add(Term t1, Term t2){
        return new Term(t1.pow, t1.coeff+t2.coeff);
    }
    
    private static Term[] multiplyPoly(Term[] t1Terms, Term[] t2Terms){
        int nTermsT1 = t1Terms.length;
        int nTermsT2 = t2Terms.length;
        
        Term[] result = new Term[nTermsT1+nTermsT2];
        for(int i=0; i<nTermsT1+nTermsT2; i++)
            result[i] = new Term(i,0);
        for(int i=0; i<nTermsT1; i++){
            for(int j=0; j<nTermsT2; j++){
                result[i+j] = add(result[i+j], multiply(t1Terms[i], t2Terms[j]));
            }
        }
        return result;
    }
    
    private static Term[] addPoly(Term[] t1Terms, Term[] t2Terms){
        int nTermsT1 = t1Terms.length;
        int nTermsT2 = t2Terms.length;
        
        Term[] result = new Term[Math.max(nTermsT1, nTermsT2)];
        for(int i=0; i<nTermsT1; i++){
            Term t1 = t1Terms[i];
            boolean foundCounter = false;
            
            for(int j=0; j<nTermsT2; j++){
                Term t2 = t2Terms[j];
                if(t1.pow==t2.pow){
                    foundCounter = true;
                    Term res = add(t1, t2);
                    result[t1.pow] = res;
                }
            }
            
            if(!foundCounter){
                result[t1.pow] = t1;
            }
        }
        
        for(int i=0; i<nTermsT2; i++){
            Term t1 = t2Terms[i];
            boolean foundCounter = false;
            
            for(int j=0; j<nTermsT1; j++){
                Term t2 = t1Terms[j];
                if(t1.pow==t2.pow){
                    foundCounter = true;
                }
            }
            
            if(!foundCounter){
                result[t1.pow] = t1;
            }
        }
        return result;
    }
}
