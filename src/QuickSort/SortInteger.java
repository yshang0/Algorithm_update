package QuickSort;

public class SortInteger {
    //No.464:Sort Integers;
    public void sortIntegers2(int[] A) {
        helper(A, 0, A.length - 1);
    }
    private void helper(int[] A, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = A[left];
        int i = left, j = right;

        while(i <= j){
            while(i <= j && A[i] < pivot){
                i++;
            }
            while(i <= j && A[j] > pivot){
                j--;
            }
            if(i <= j){
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
                i++;
                j--;
            }
        }
        helper(A, left, j);
        helper(A, i, right);
    }
}
