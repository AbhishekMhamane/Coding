public class RecursionStringPalindrom {

    public static boolean isPalindrome(String input,int start,int end)
    {
        if(start>=end) return true;

        if(input.charAt(start)!=input.charAt(end)) return false;

        boolean isCheckPalindrome = isPalindrome(input,start+1,end-1);

        return isCheckPalindrome;
    }
    public static void main(String[] args)
    {
        String input = "abcba";
        int start = 0;
        int end = input.length()-1;
        System.out.println(isPalindrome(input,start,end));
    }
}
