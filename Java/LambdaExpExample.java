import java.util.ArrayList;

@FunctionalInterface // Optional
interface Addition {
  public int addtion(int a, int b);
}

public class LambdaExpExample {

  public static void main(String[] args) {
    System.out.println("Lamda Expression Examples");
    // example 1
    System.out.println("Example 1");

    int a = 5, b = 5;

    Addition add = (c, p) -> {
      return c + p;
    };

    System.out.println(add.addtion(a, b));

    //example 2
    System.out.println("Example 2");

    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    list.forEach(i -> System.out.print(i + " "));
  }
}
