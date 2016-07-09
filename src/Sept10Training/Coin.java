package Sept10Training;

import java.util.Scanner;

public class Coin {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int nCoins = sc.nextInt();
            int nWeighings = sc.nextInt();
            boolean[] coinsAssumingHeavy = new boolean[nCoins];
            boolean[] coinsAssumingLight = new boolean[nCoins];

            for(int i=0; i<nWeighings; i++){
                int nCoinsPerSide = sc.nextInt();
                int[] left = new int[nCoinsPerSide];
                int[] right = new int[nCoinsPerSide];
                for(int j=0; j<nCoinsPerSide; j++) left[j] = sc.nextInt()-1;
                for(int j=0; j<nCoinsPerSide; j++) right[j] = sc.nextInt()-1;

                char result = sc.next().charAt(0);
                if(result=='>'){
                    for(int j=0; j<nCoinsPerSide; j++){
                        coinsAssumingHeavy[right[j]] = true;
                        coinsAssumingLight[left[j]] = true;
                    }
                } else if(result=='<'){
                    for(int j=0; j<nCoinsPerSide; j++){
                        coinsAssumingHeavy[left[j]] = true;
                        coinsAssumingLight[right[j]] = true;
                    }
                } else {
                    for(int j=0; j<nCoinsPerSide; j++){
                        coinsAssumingHeavy[left[j]] = true;
                        coinsAssumingHeavy[right[j]] = true;
                        coinsAssumingLight[left[j]] = true;
                        coinsAssumingLight[right[j]] = true;
                    }
                }
                System.out.print("Heavy: ");
            for(int ii=0; ii<nCoins; ii++){
                System.out.print(coinsAssumingHeavy[ii]+" ");
            }
            System.out.println("");
                System.out.print("Light: ");
            for(int ii=0; ii<nCoins; ii++){
                System.out.print(coinsAssumingLight[ii]+" ");
            }
            System.out.println("");
                System.out.println("");
            }

            int nFalse = 0;
            int res = 0;
            for(int i=0; i<nCoins; i++){
                if(coinsAssumingHeavy[i]==false){
                    nFalse++;
                    res = i+1;
                }
            }
            if(nFalse==1){
                System.out.println(res);
            } else{
                nFalse = 0;
                res = 0;
                for(int i=0; i<nCoins; i++){
                    if(coinsAssumingLight[i]==false){
                        nFalse++;
                        res = i+1;
                    }
                }
                if(nFalse==1){
                    System.out.println(res);
                } else System.out.println("0");
            }
        }
    }
}
