import java.util.*;

public class RecursionFibonacci {

    public static void callFibo(int n,int prev,int temp,int i)
    {
        System.out.println(temp);
        
        if(i==n) return;

        int dummy = prev;
        prev = temp;
        temp = dummy + temp;

        callFibo(n,prev,temp,i+1);
    }
    public static void main(String[] args){

        int n = 8;
        callFibo(n,1,0,0);
    }
}
