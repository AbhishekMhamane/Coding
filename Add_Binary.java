class Add_Binary {

  public static String addBinary(String a, String b) {
    int maxLength = a.length() > b.length() ? b.length() : a.length();
    String resultOfAdd = "";
    String ch = "0";
    StringBuilder one = new StringBuilder();
    one.append(a);
    one.reverse();
    String first = one.toString();

    StringBuilder second = new StringBuilder();
    second.append(b);
    second.reverse();
    String two = second.toString();

    //   System.out.println(first);
    //   System.out.println(second);

    int i = 0;

    for (i = 0; i < maxLength; i++) {
      if (first.charAt(i) == '1' && two.charAt(i) == '1') {
        if (ch == "1") {
          resultOfAdd = resultOfAdd + "1";
        } else {
          resultOfAdd = resultOfAdd + "0";
        }
        ch = "1";
      } else if (first.charAt(i) == '0' && two.charAt(i) == '0') {
        if (ch == "1") {
          resultOfAdd = resultOfAdd + "1";
          ch = "0";
        } else {
          resultOfAdd = resultOfAdd + "0";
        }
      } else {
        if (ch == "1") {
          resultOfAdd = resultOfAdd + "0";
          ch = "1";
        } else {
          resultOfAdd = resultOfAdd + "1";
        }
      }
    }

    if (i < a.length()) {
      while (i < a.length()) {
        if (first.charAt(i) == '1') {
          if (ch == "1") {
            resultOfAdd = resultOfAdd + "0";
            ch = "1";
          } else {
            resultOfAdd = resultOfAdd + "1";
          }
        } else {
          if (ch == "1") {
            resultOfAdd = resultOfAdd + "1";
            ch = "0";
          } else {
            resultOfAdd = resultOfAdd + "0";
          }
        }
        i++;
      }
    } else if (i < b.length()) {
      while (i < b.length()) {
        if (second.charAt(i) == '1') {
          if (ch == "1") {
            resultOfAdd = resultOfAdd + "0";
            ch = "1";
          } else {
            resultOfAdd = resultOfAdd + "1";
          }
        } else {
          if (ch == "1") {
            resultOfAdd = resultOfAdd + "1";
            ch = "0";
          } else {
            resultOfAdd = resultOfAdd + "0";
          }
        }
        i++;
      }
    }

    if (ch == "1") {
      resultOfAdd = resultOfAdd + "1";
    }
    StringBuilder last = new StringBuilder();
    last.append(resultOfAdd);
    last.reverse();
    resultOfAdd = last.toString();
    return resultOfAdd;
  }

  public static void main(String args[]) {
    String a = "11";
    String b = "1";
    String resultAddition = addBinary(a, b);
    System.out.println(resultAddition);
  }
}
