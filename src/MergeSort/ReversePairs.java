package MergeSort;

public class ReversePairs {
    //No. 532: ReversePairs; 返回有多少对pairs；
    //For an array A, if i < j, and A [i] > A [j], called (A [i], A [j]) is a reverse pair. return total of reverse pairs in A.
    public long reversePairs(int[] A) {
        // write your code here
        int[] temp = new int[A.length];
        long result = (long)helper(A, temp, 0, A.length - 1);
        return result;
    }
    private int helper(int[] A, int[] temp, int left, int right){
        if(left >= right){
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = helper(A, temp, left, mid);
        int rightPairs = helper(A, temp, mid + 1, right);
        int crossPairs = 0;
        int i = left, j = mid + 1;
        for(int k = 0; k < right - left + 1; k++){
            if(j > right || i < mid + 1 && A[i] <= A[j]){
                temp[left + k] = A[i++];
            } else {
                temp[left + k] = A[j++];
                if(i <= mid){
                    crossPairs += mid - i + 1;
                }
            }
        }
        for(int k = 0; k < right - left + 1; k++){
            A[left + k] = temp[left + k];
        }
        return leftPairs + rightPairs + crossPairs;
    }
}
