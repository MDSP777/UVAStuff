package uvastuff;

import java.math.BigInteger;
import java.util.Scanner;

public class N12470 {    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.nextLine());
        while(n.compareTo(BigInteger.ZERO)!=0){
            System.out.println(tribo(n).mod(new BigInteger("1000000009")));
            n = new BigInteger(sc.nextLine());
        }

    }
    
    public static BigInteger tribo(BigInteger n){
        BigInteger first = BigInteger.ZERO;
        BigInteger second = BigInteger.ONE;
        BigInteger third = new BigInteger("2");
        BigInteger fourth = new BigInteger("3");
        if(n.compareTo(BigInteger.ONE)==0) return first;
        if(n.compareTo(third)==0) return second;
        if(n.compareTo(new BigInteger("3"))==0) return third;
        for(BigInteger a = new BigInteger("4"); a.compareTo(n)<1; a = a.add(BigInteger.ONE)){
            fourth = first.add(second).add(third);
            first = second;
            second = third;
            third = fourth;
        }
        return fourth;
    }
}
