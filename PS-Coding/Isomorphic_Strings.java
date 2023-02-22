import java.util.*;

public class Isomorphic_Strings {

  public boolean isIsomorphic(String s, String t) {

    if (s.length() != t.length()) return false;

    HashMap<Character, Character> smap = new HashMap<>();
    HashMap<Character, Character> tmap = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      if (smap.containsKey(s.charAt(i))) {
        if (t.charAt(i) != smap.get(s.charAt(i))) {
          return false;
        }
      } else if (tmap.containsKey(t.charAt(i))) {
        if (s.charAt(i) != tmap.get(t.charAt(i))) {
          return false;
        }
      } else {
        smap.put(s.charAt(i), t.charAt(i));
        tmap.put(t.charAt(i), s.charAt(i));
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Isomorphic_Strings obj = new Isomorphic_Strings();
    String s = "paper";
    String t = "title";
    boolean result = obj.isIsomorphic(s, t);
    System.out.println(result);
  }
}
