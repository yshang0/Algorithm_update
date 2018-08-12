package QuickSort;

public class SortColors {
    // No.148: Sort Colors;
    public void sortColors(int[] nums) {
        helper(nums, 0);
        helper(nums, 1);
    }
    private void helper(int[] nums, int pivot) {
        int i = 0, j = nums.length - 1;

        while(i <= j) {
            while(i <= j && nums[i] <= pivot) {
                i++;
            }
            while(i <= j && nums[j] > pivot) {
                j--;
            }
            if(i <= j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
        }
    }
}
