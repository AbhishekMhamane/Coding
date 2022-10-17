import java.util.*;
public class RecursionSubset {

    public static void helper(int arr[],Stack<Integer> temp,int index)
    {
        if(index >= arr.length)
        {
            if(!temp.isEmpty())
            {
            System.out.println(temp);
            }
            return;
        }

        //take
        temp.push(arr[index]);
        helper(arr, temp, index+1);

        //not take
        temp.pop();
        helper(arr, temp, index+1);
    }

    public static void main(String[] args)
    {
        int arr[] = {1,2,3};
        Stack<Integer> temp = new Stack<Integer>();
        helper(arr,temp,0);
    }
}
