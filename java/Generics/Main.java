public class Main {

  public static class Emp {

    int id;
    String name;

    public Emp(int id, String name) {
      this.id = id;
      this.name = name;
    }
  }

  public static void main(String[] args) {
    System.out.println("Generics Examples");

    System.out.println("Generics using Integer");
    MyList<Integer> list = new MyList<Integer>();

    for (int i = 0; i < 10; i++) {
      list.add(i);
    }

    int n = list.getSize();
    for (int i = 0; i < n; i++) {
      System.out.println(list.get(i));
    }

    System.out.println("Generics using Emp");

    MyList<Emp> elist = new MyList<Emp>();
    elist.add(new Emp(1, "abhi"));
    elist.add(new Emp(2, "mahesh"));

    int size = elist.getSize();

    for (int i = 0; i < size; i++) {
      Emp temp = elist.get(i);
      System.out.println(temp.id + " " + temp.name);
    }
  }
}
