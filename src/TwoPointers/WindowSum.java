package TwoPointers;

public class WindowSum {
    // No.604: Window Sum;
    public int[] winSum(int[] nums, int k) {
        if(nums == null || nums.length < k || k <= 0){
            return new int[0];
        }
        int[] sums = new int[nums.length - k + 1];

        for(int i = 0; i < k; i++){
            sums[0] += nums[i];
        }

        for(int i = k, j = 1; i < nums.length; i++, j++){
            sums[j] = sums[j - 1] + nums[i] - nums[i - k];
        }
        return sums;
    }
}
