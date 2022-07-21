public class Palindrome_Number {

    public static boolean isPalindrome(int number)
    {
        if(number < 0 )
        {
            return false;
        }

        int temp = number;
        int reverseNumber = 0;
        while(temp!=0)
        {
            reverseNumber = reverseNumber * 10 + (temp%10);
            temp = temp / 10;
        }

        if(reverseNumber == number)
        {
            return true;
        }
        return false;
    }
    public static void main(String args[])
    {
        int input = 217;
        System.out.println(isPalindrome(input));
    }
}
