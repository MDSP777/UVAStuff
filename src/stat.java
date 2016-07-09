
import java.math.BigInteger;

public class stat {
    static BigInteger[] factorial = new BigInteger[10001];
    
    public static void main(String[] args){
//        factorial[0] = BigInteger.ONE;
//        for(int i=1; i<=10000; i++)
//            factorial[i] = factorial[i-1].multiply(new BigInteger(i+""));
////        System.out.println(permutation(6, 2).multiply(permutation(5, 3)));
////        System.out.println(27*37);
////        System.out.println(combination(18, 1).multiply(combination(325, 1)));
////        System.out.println(combination(18+325, 1));
////        System.out.println(combination(6, 2).multiply(new BigInteger("4")));
////        System.out.println(permutation(6, 2).multiply(new BigInteger("4")));
//        System.out.println(factorial[10000]);
        double[] x = {1, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2};
        double[] y = {8.1, 7.8, 8.5, 9.8, 9.5, 8.9, 8.6, 10.2, 9.3, 9.2, 10.5};
        System.out.printf("yhat = %.3f+%.3fx\n", b0(x, y), b1(x, y));
        System.out.println(yhat(1.75, x, y));
    }
    
    static double e(int i, double[] x, double[] y){
        return y[i]-yhat(x[i], x, y);
    }
    
    static double yhat(double term, double[] x, double[] y){
        return b0(x, y)+b1(x, y)*term;
    }
    
    static double b0(double[] x, double[] y){
        return mean(y)-b1(x, y)*mean(x);
    }
    
    static double b1(double[] x, double[] y){
        int n = x.length;
        double num = 0;
        double denom = 0;
        for(int i=0; i<n; i++){
            num+=(x[i]-mean(x))*(y[i]-mean(y));
            denom+=(x[i]-mean(x))*(x[i]-mean(x));
        }
        return num/denom;
    }
    
    static double mean(double[] arr){
        double total = 0;
        for(int i=0; i<arr.length; i++)
            total+=arr[i];
        return total/arr.length;
    }
    
    // sample correlation coefficient
    static double scc(double[] x, double[] y){
        double total = 0;
        double term1 = 0;
        double term2 = 0;
        for(int i=0; i<x.length; i++){
            total+=((x[i]-mean(x))*(y[i]-mean(y)));
            term1+=(Math.pow(x[i]-mean(x), 2));
            term2+=(Math.pow(y[i]-mean(y), 2));
        }
        term1*=term2;
        double denom = Math.sqrt(term1);
        return total/denom;
    }
    
    static BigInteger permutation(int n, int r){
        if(r<=n)
            return factorial[n].divide(factorial[n-r]);
        return new BigInteger("-1");
    }
    
    static BigInteger combination(int n, int k){
        if(k<=n)
            return factorial[n].divide(factorial[k].multiply(factorial[n-k]));
        return new BigInteger("-1");
    }
}
