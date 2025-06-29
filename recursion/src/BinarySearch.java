import com.sun.source.tree.WhileLoopTree;

public class BinarySearch {

  public int binarySearch(int low, int high, int nums[], int ele){

    if(low <= high){
      int mid = low + (high-low) / 2;

      if(nums[mid] == ele){
        return mid;
      }

      // if ele is greater than curr
      if(nums[mid] < ele){
        return binarySearch(mid + 1, high, nums, ele);
      }

      // if ele is smaller than curr
      return binarySearch(low, mid - 1, nums, ele);
    }

    return -1;
  }


  public static void main(String[] args) {
    BinarySearch obj = new BinarySearch();
    int nums[] = {2, 3, 4, 10, 40 };
    int x = 40;
    System.out.println(obj.binarySearch(0, nums.length-1, nums, x));
  }
}
