import java.util.ArrayList;
import java.util.List;

/**
 * Pascal'sTriangle
 */
public class PascalsTriangle {

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> prevSumList = new ArrayList<Integer>();

    for (int i = 1; i <= numRows; i++) {
      List<Integer> tempList = new ArrayList<Integer>();

      int calRemainingSpace = i - 2;

      if (calRemainingSpace <= 0) {
        for (int j = 1; j <= i; j++) {
          tempList.add(1);
        }

        if (i == 2) {
          for (int k = 0; k < tempList.size() - 1; k++) {
            int sum = tempList.get(k) + tempList.get(k + 1);
            prevSumList.add(sum);
          }
        }
      } else {
        tempList.add(1);

        for (Integer ele : prevSumList) {
          tempList.add(ele);
        }
        prevSumList.clear();
        tempList.add(1);

        for (int k = 0; k < tempList.size() - 1; k++) {
          int sum = tempList.get(k) + tempList.get(k + 1);
          prevSumList.add(sum);
        }
      }

      result.add(tempList);
    }

    return result;
  }

  public static List<Integer> getRow(int rowIndex) {
    List<List<Integer>> result = generate(rowIndex + 1);
    return result.get(rowIndex);
  }

  public static void main(String[] args) {
    int numRows = 5;
    List<List<Integer>> result1 = generate(numRows);
    System.out.println("result1 " + result1);

    int rowIndex = 3;
    List<Integer> result2 = getRow(rowIndex);
    System.out.println("result2 " + result2);
  }
}
