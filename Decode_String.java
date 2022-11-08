import java.util.*;
public class Decode_String {
    
    public static String decodeString(String s) {
        String result = "";

        Stack<String> stack = new Stack<String>();

        int i = 0;

        while(i<s.length()) {

          
            if(s.charAt(i) == '[' || Character.isAlphabetic(s.charAt(i)))
            {
                stack.push(Character.toString(s.charAt(i)));
            }
            else if(Character.isDigit(s.charAt(i)))
            {
                String sDigit="";
                int j = i;
                while(Character.isDigit(s.charAt(j)))
                {
                    sDigit = sDigit + Character.toString(s.charAt(j));
                    j++;
                }
                i = j-1;
                stack.push(sDigit);
            }
            else
            {
                String temp = "";
              
                while(!stack.peek().equals("["))
                {
                    String tt = stack.pop();
                    temp = tt + temp;
                }
                
               stack.pop();

                if(Character.isDigit(stack.peek().charAt(0)))
                {
                    int j = Integer.parseInt(stack.pop());

                    String newSt="";
                    for(int k = 0;k<j;k++)
                    {
                        newSt = newSt+temp;
                    }

                    temp = newSt;
                }

                stack.push(temp);

            }

            i++;
        }

        Iterator value = stack.iterator();
         while (value.hasNext()) {
           result = result + value.next();
        }

        return result;
    }


    public static void main(String[] args)
    {
        String s = "2[ab2[cd]]";
        String result = decodeString(s);
        System.out.println(result);
    }
}
