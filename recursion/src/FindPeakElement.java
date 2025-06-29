public class FindPeakElement {
  public int findPeakElement(int nums[]){

    // if only one element
    if(nums.length == 1) return 0;

    // if 2 element
    if(nums.length == 2) {
      return (nums[0] > nums[1] ? 0 : 1);
    }

    //check first ele is peak
    if(nums[0] > nums[1]) return 0;

    // check last ele is peak
    if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;

    return solve(1, nums.length-2, nums);
  }

  public int solve(int low, int high, int nums[]){

    //bc
    if(low<=high){

      int mid = low + (high-low)/2;

      if(nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]) {
        return mid;
      }

      if(nums[mid] < nums[mid+1]) return solve(mid+1, high, nums);
      else return solve(low, mid-1, nums);
    }

    return -1;
  }


  public static void main(String[] args) {
    FindPeakElement obj = new FindPeakElement();
    int nums[] = {1,2,1,3,5,6,4};
    System.out.println(obj.findPeakElement(nums));
  }
}
