import java.util.HashMap;

public class IsomorphicStrings {

  public boolean isIsomorphic(String s, String t) {

    HashMap<Character, Character> map = new HashMap<>();

    if(s.length() != t.length()) {
      return false;
    }

    for(int i=0;i<s.length();i++){
      char temp = s.charAt(i);

      if(map.containsKey(temp)){
        if(map.get(temp) != t.charAt(i)){
          return false;
        }
      }else{
        if(map.containsValue(t.charAt(i))){
          return false;
        }
        map.put(temp, t.charAt(i));
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
  }
}
