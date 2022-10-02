class Valid_Palindrome
{
    public static boolean isPalindrome(String s) {
        
        String lowerCase = s.toLowerCase();
        String alphabetString="";
        for(int i=0;i<lowerCase.length();i++)
        {
            if(Character.isLetter(lowerCase.charAt(i)) || Character.isDigit(lowerCase.charAt(i)))
            {
                alphabetString = alphabetString + lowerCase.substring(i,i+1);
            }
        }

        //System.out.println(alphabetString);

        int i=0,j=alphabetString.length()-1;
        while(i<j)
        {
            if(alphabetString.charAt(i)!=alphabetString.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String args[])
    {
        String s ="0p";
        System.out.println(isPalindrome(s));
    }
}