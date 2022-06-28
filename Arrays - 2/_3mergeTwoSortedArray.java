public class _3mergeTwoSortedArray {

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static int nextGap(int gap) {
    if (gap <= 1)
      return 0;
    return (gap / 2) + (gap % 2);
  }

  static void merge(int ar1[], int ar2[], int m, int n) {
    // code here
    int gap = nextGap(m + n);
    while (gap > 0) {
      int i = 0;
      int j = gap;
      while (j < (n + m)) {
        if (j < m && ar1[i] > ar1[j]) {
          swap(ar1, i, j);
        } else if (j >= m && i < m && ar1[i] > ar2[j - m]) {
          int t = ar1[i];
          ar1[i] = ar2[j - m];
          ar2[j - m] = t;
        } else if (j >= m && i >= m && ar2[i - m] > ar2[j - m]) {
          swap(ar2, i - m, j - m);
        }
        j++;
        i++;
      }
      gap = nextGap(gap);
    }
  }

  public static void main(String[] args) {
    int arr1[] = { 1, 4, 7, 8, 10 };
    int arr2[] = { 2, 3, 9 };
    System.out.println("Before merge:");
    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }
    System.out.println();
    merge(arr1, arr2, arr1.length, arr2.length);
    System.out.println("After merge:");
    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }
  }

}
