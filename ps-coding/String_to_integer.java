
public class String_to_integer {

    public static int myAtoi(String input)
    {
        long convertedNumber=0;
        boolean isNegative = false; 
        int i=0;
        int len = input.length();

        while(i<input.length() && input.charAt(i) == ' ')
        {
            i++;
        }

        if(i==input.length())
        {
            return 0;
        }
        
        if(input.charAt(i) == '-')
        {
            isNegative = true;
            i++;
        }
        else if(input.charAt(i) == '+')
        {
            i++;
        }

        while(i<input.length() && input.charAt(i)=='0'){
            i++;
        }
   
        
        if(len>i+11){
            len = i+11;
        }
        

        for(;i<len;i++)
        {
            char ch = input.charAt(i);

            if(ch>='0' && ch<='9')
            {
                convertedNumber = convertedNumber * 10 + ch - '0';
            }
            else
            {
                break;
            }
            
        }

        if(isNegative)
        {
            convertedNumber = -convertedNumber;
        }

        if(convertedNumber > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        if(convertedNumber < Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }
        return (int)convertedNumber;
    }
    public static void main(String args[])
    {
       String input = "9223372036854775808";
       int convertedNumber = myAtoi(input);
       System.out.println(convertedNumber);
    }
}
