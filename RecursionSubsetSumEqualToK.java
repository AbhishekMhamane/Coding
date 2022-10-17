public class RecursionSubsetSumEqualToK {
    
    public static boolean helper(int arr[],int sum,int tempSum,int i) 
    {
        if(sum == tempSum) return true;

        if(i>=arr.length) return false;

        boolean check1 = helper(arr, sum, tempSum+arr[i], i+1);
        
        boolean check2 = helper(arr, sum, tempSum, i+1);

        return check1 || check2;

    }

    public static void main(String[] args)
    {
        int arr[] = {3,34,4,12,5,2};
        System.out.println(helper(arr,100,0,0));
    }
}
