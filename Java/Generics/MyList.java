import java.util.Arrays;

// generic type class
public class MyList<T> {

  private Object obj[];

  private T t;

  private int i = 0;

  MyList() {
    obj = new Object[5];
  }

  public void add(T val) {
    this.t = val;

    if (i == obj.length - 1) {
      obj = Arrays.copyOf(obj, obj.length + (obj.length / 2));
    }

    this.obj[i] = t;
    i++;
  }

  public T get(int index) {
    if (index > i || index < 0) {
      return null;
    }
    return (T) this.obj[index];
  }

  public int getSize() {
    return i;
  }
}
