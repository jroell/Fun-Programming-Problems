import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CountInversions {

  private CountInversions() {}

  /**
   * Returns the number of inversions in the input array
   *
   * @param a the input array
   * @return  the number of inversions.
   */
  public static int countInversions(ArrayList<Integer> a) {
    List<Integer> temp = Arrays.asList(new Integer[a.size()]);
    return mergeSort(a, temp, 0, a.size() - 1);
  }

  private static int mergeSort (ArrayList<Integer> a, List<Integer> temp, int low, int high) {
    int mid, inversionCount = 0;
    if (low < high) {

      mid = low + (high - low)/ 2;

      inversionCount = mergeSort(a, temp, low, mid);
      inversionCount += mergeSort(a, temp, mid + 1, high);
      inversionCount += merge(a, temp, low, mid + 1, high);
    }

    return inversionCount;
  }

  private static int merge (ArrayList<Integer> a, List<Integer> temp, int low, int mid, int high) {
    int i = low; // index of left subarray
    int j = mid; // index of right subarray
    int k = low; // index of temp/sorted array
    int inversionCount = 0;

    while ((i <= mid - 1) && (j <= high)){
      if (a.get(i) <= a.get(j)){
        temp.set(k, a.get(i));
        k++;
        i++;
      }
      else {
        temp.set(k, a.get(j));
        k++;
        j++;

        inversionCount += (mid - i);
      }
    }

    while (i <= mid - 1){
      temp.set(k, a.get(i));
      i++;
      k++;
    }

    while (j <= high){
      temp.set(k, a.get(j));
      j++;
      k++;
    }

    for (i = low; i <= high; i++){
      a.set(i, temp.get(i));
    }

    return inversionCount;
  }
}
