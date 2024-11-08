import java.util.*;
import java.lang.*;

public class Count_Good_Numbers {
    
    public static long mod = 1000000007;
    public static int countGoodNumbers(long n) {
        //finding the positions of even and odd
        long even = (n+1)/2;
        long odd = n/2;
        // System.out.println(even);
        // System.out.println(odd);

        return (int)(pow(5,even)*pow(4,odd)%mod);
    }

    public static long pow(long x,long n)
    {
        if(n==0) return 1;

        long temp = pow(x,n/2);

        if(n%2==0)
        {
            return (temp*temp)%mod;
        }
        else
        {
            return (x*temp*temp)%mod;
        }

    }

    public static void main(String[] args)
    {
        int temp = countGoodNumbers(4);
        System.out.println(temp);
    }
}
