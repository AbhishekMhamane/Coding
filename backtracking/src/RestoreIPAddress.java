import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

  // main function
  public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    restoreIpAddressesHelper(0,3,new ArrayList<String>(),s,result);
    return result;
  }

  // backtrack helper function
  public void restoreIpAddressesHelper(int index, int n, List<String> temp, String s, List<String> result){

    //base codition
    if((index == s.length()) && (temp.size() == n+1)){
      String finalString = buildAndGetStr(temp);
      result.add(finalString);
    }

    //choices
    for(int i=index; i<s.length(); i++){
      String subStr = s.substring(index,i+1);
      if(isValidSubStr(subStr,n,temp)){
         temp.add(subStr);
         restoreIpAddressesHelper(i+1, n, temp, s, result);
         temp.remove(temp.size()-1);
       }
    }
  }

  // check if the substring is valid
  public boolean isValidSubStr(String subStr, int n, List<String> temp){
    if(subStr.charAt(0)=='0' && subStr.length()>1) return false;
    if(subStr.length() > n) return false;
    int parsedInteger = Integer.parseInt(subStr);
    if(parsedInteger >255) return false;
    if(temp.size() == n+1) return false;
    return true;
  }

  // build the string
  public String buildAndGetStr( List<String> temp){
    StringBuilder builder = new StringBuilder();
    for(String i : temp){
      builder.append(i);
      builder.append(".");
    }
    builder.deleteCharAt(builder.length()-1);
    return builder.toString();
  }

  public static void main(String[] args) {
    RestoreIPAddress add = new RestoreIPAddress();
    String s = "101023";
    System.out.println(add.restoreIpAddresses(s));
  }
}
