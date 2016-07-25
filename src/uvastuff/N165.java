package uvastuff;

import java.util.ArrayList;
import java.util.Scanner;

public class N165 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int h = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<String> attempts = new ArrayList<>();
            if(h==0 && k==0) break;
            
            int[] denoms = new int[k];
            for(int i=1; i<=k; i++){
                denoms[i-1] = i;
            }
            int indexToEdit = k-1;
            int largest = k;
            
        }

    }

    private static boolean canProduce(int[] denoms, int nTerms, int attempt) {
        if(attempt<=0) return false;
        if(nTerms==1){
            for(int i=0; i<denoms.length; i++){
                if(denoms[i]==attempt) return true;
            }
            return false;
        }
        for(int i=0; i<denoms.length; i++){
            if(canProduce(denoms, nTerms-1, attempt=denoms[i])) return true;
        }
        return false;
    }
}
