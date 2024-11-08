public class RecursionPowerSet {
    
    public static void helper(String s,String temp,int index)
    {
        if(index>=s.length()) {
            System.out.print(temp+" ");
            return;
        }

        //take
        helper(s,temp+Character.toString(s.charAt(index)),index+1);

        //not take
        helper(s,temp,index+1);

    }

    public static void main(String[] args)
    {
        String s="abc";
        helper(s,"",0);
    }
}
