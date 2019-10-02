public class Solution {

    int comparisonCount;
    int[] sortingArray;

    Solution(int[] input)
    {
        sortingArray = input;
        comparisonCount = 0;
    }


    public static void main(String[] args) {
        // TODO code application logic here
    }

    public void mergeSort(int p, int r) {
        if(p<r){
            int q = (p+r)/2;
            mergeSort(p,q);
            mergeSort(q+1, r);
            merge(p,q,r);
        }
    }

    public void insertionSort() {
        for(int j = 1; j < sortingArray.length; j++){
            int key = sortingArray[j];
            int i = j-1;

            while(i>=0){
                comparisonCount++;
                if (sortingArray[i]<key)break;
                sortingArray[i+1] = sortingArray[i];
                i = i-1;
            }
            sortingArray[i+1] = key;
        }
    }

    public  void heapSort()  {
        buildMaxHeap();
        int heapSize = sortingArray.length;
        for(int i = sortingArray.length-1; i>0; i--){
            swap(0, i);
            heapSize = heapSize - 1;
            maxHeapify(0, heapSize);
        }
    }

    private void merge(int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1+1];
        int[] R = new int[n2+1];

        for(int i = 0; i < n1; i++){
            L[i] = sortingArray[p+i];
        }

        for(int i = 0; i < n2; i++){
            R[i] = sortingArray[q+i+1];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for(int k = p; k <= r; k++){
            comparisonCount++;
            if(L[i] <= R[j]){
                sortingArray[k] = L[i];
                i = i+1;
            } else {
                sortingArray[k] = R[j];
                j = j+1;
            }
        }
    }

    private void maxHeapify(int i, int heapSize){
        int l = left(i);
        int r = right(i);

        int largest = i;

        if (l < heapSize){
            comparisonCount++;
            if(sortingArray[l] > sortingArray[i])largest = l;
        }

        if (r < heapSize){
            comparisonCount++;
            if(sortingArray[r] > sortingArray[largest])largest = r;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest, heapSize);
        }
    }

    private void buildMaxHeap() {
        int i = (sortingArray.length - 1) / 2;
        while (i >= 0)
        {
            maxHeapify(i, sortingArray.length);
            i--;
        }
    }

    private int left(int i){
        return 2*i + 1;
    }

    private int right(int i){
        return 2*i + 2;
    }

    private void swap(int i, int j) {
        sortingArray[i] = (sortingArray[i] + sortingArray[j]) - (sortingArray[j] = sortingArray[i]);
    }
}
