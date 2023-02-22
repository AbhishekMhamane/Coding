import java.util.*;

public class RecursionPrintMobileKeyboardWords {
    
    static String arr[] = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> arrList = new ArrayList<String>();

    public static void printWords(int input[],String temp,int n,int i)
    {
        if(i==n)
        {
            arrList.add(temp);
            return;
        }

        for(int j=0;j<arr[input[i]-1].length();j++)
        {
            printWords(input,temp+Character.toString(arr[input[i]-1].charAt(j)),n,i+1);
        }
    }

    public static void main(String args[])
    {
        int input[] = {2,3,4};
        int n = 3;
        printWords(input,"",n,0);
        System.out.println(arrList);
    }
}
