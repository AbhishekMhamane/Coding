public class Longest_Common_Prefix {

    public static String longestCommonPrefix(String[] strs){

        String longestPrefix = "";

        for(int i=0;i<strs[0].length();i++)
        {
            char subStr = strs[0].charAt(i);

            for(int j=1;j<strs.length;j++)
            {
                if(i<strs[j].length())
                {
                    if(subStr!=strs[j].charAt(i))
                    {
                        return longestPrefix;
                    }
                }
                else return longestPrefix;
            }

            longestPrefix = longestPrefix + subStr;
        }

        return longestPrefix;
    }
    public static void main(String[] args)
    {
        String strs[] = {"flower","flow","flight"};
        String longestPrefix = longestCommonPrefix(strs);
        System.out.println("Longest Prefix is : "+longestPrefix);
    }
}
