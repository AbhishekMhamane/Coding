import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber {

  public boolean isAdditiveNumber(String num) {
    return isAddNumHelper(0, num, new ArrayList<>());
  }

  private boolean isAddNumHelper(int index, String num, List<String> sequence) {
    if (index == num.length()) {
      return sequence.size() >= 3 && isValidAdditiveSequence(sequence);
    }

    for (int i = index; i < num.length(); i++) {
      String currentNum = num.substring(index, i + 1);
      if (currentNum.length() > 1 && currentNum.startsWith("0")) {
        break;
      }

      sequence.add(currentNum);
      if (sequence.size() < 3 || isValidAdditiveSequence(sequence)) {
        if (isAddNumHelper(i + 1, num, sequence)) return true;
      }
      sequence.remove(sequence.size() - 1);
    }

    return false;
  }

  private boolean isValidAdditiveSequence(List<String> sequence) {
    int size = sequence.size();
    if (size < 3) {
      return true;
    }
    double num1 = Double.parseDouble(sequence.get(size - 3));
    double num2 = Double.parseDouble(sequence.get(size - 2));
    double num3 = Double.parseDouble(sequence.get(size - 1));
    return num1 + num2 == num3;
  }

  public static void main(String[] args) {
    String num = "112358";
    AdditiveNumber add = new AdditiveNumber();
    System.out.println(add.isAdditiveNumber(num));
  }
}
