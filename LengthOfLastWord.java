
class LengthOfLastWord
{

       public static int lengthOfLastWord(String s) {
        
        int lengthOfLastWord = 0;
        int currentlength=0;
        for(int i=0;i<s.length();i++)
        {
            char temp = s.charAt(i);
            if(temp==' ')
            {
                if(currentlength!=0)
                {
                lengthOfLastWord=currentlength;
                currentlength=0;
                }
            }
            else
            {
              currentlength++;
            }
        }

        if(currentlength>0) lengthOfLastWord=currentlength;

        return lengthOfLastWord;
    }

    public static void main(String args[])
    {
        String s = "luffy is still joyboy";
        int lengthOfLastWord = lengthOfLastWord(s);
        System.out.println(lengthOfLastWord);
    }
}