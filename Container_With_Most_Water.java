public class Container_With_Most_Water {

  public static int maxArea(int height[]) {
    int maxAreaCount = 0;
    int p1 = 0, p2 = height.length - 1;

    while (p1 < p2) {
      int minNo = Math.min(height[p1], height[p2]);
      int width = p2 - p1;
      int product = width * minNo;
      maxAreaCount = Math.max(maxAreaCount, product);

      if (height[p1] < height[p2]) {
        p1++;
      } else {
        p2--;
      }
    }
    return maxAreaCount;
  }

  public static void main(String args[]) {
    int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
    System.out.print("Given height array : ");
    for (int i = 0; i < height.length; i++) {
      System.out.print(height[i] + " ");
    }
    System.out.println();

    int maxAreaCount = maxArea(height);
    System.out.println("Max area convered : " + maxAreaCount);
  }
}
