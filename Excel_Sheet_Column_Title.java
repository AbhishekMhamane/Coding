public class Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        StringBuilder bilder = new StringBuilder();
        
        while(n > 0){
            int rem = (n-1)%26;
            bilder.append((char)('A' + rem));
            n = (n-1)/26;
        }
        
        bilder.reverse();
        return bilder.toString();
    }
    
    public static void main(String args[])
    {
        Excel_Sheet_Column_Title obj = new Excel_Sheet_Column_Title();
        String result = obj.convertToTitle(701); 
        System.out.println(result);
    }
}
