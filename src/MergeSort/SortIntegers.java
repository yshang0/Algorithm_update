package MergeSort;

public class SortIntegers {
    //No.464: Sort Integers II 归并排序
    public void sortIntegers2(int[] A) {
        // write your code here
        int[] temp = new int[A.length];
        helper(A, temp, 0, A.length - 1);
    }
    private void helper(int[] A, int[] temp, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        helper(A, temp, left, mid);
        helper(A, temp, mid + 1, right);

        int i = left, j = mid + 1;
        for(int k = 0; k < right - left + 1; k++){
            if(j > right || i <= mid && A[i] <= A[j]){
                temp[k] = A[i++];
            } else {
                temp[k] = A[j++];
            }
        }
        for(int k = 0; k < right - left + 1; k++){
            A[left + k] = temp[k];
        }
    }
}
