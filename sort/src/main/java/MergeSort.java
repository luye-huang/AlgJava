import java.util.Arrays;
// Q 逆序对
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {32, 4, 1, -5, 6};
        sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sort(int[] arr) {
//        mergeSort(arr, 0, arr.length - 1);
        mergeSortBU(arr, arr.length);
    }

    //复杂度 nlogn, 当n比较小时，效率不如插入排序
    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (r + l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }

    private static void mergeSortBU(int[] arr, int n) {
        for (int sz = 1; sz <= n; sz += sz)
            for (int i = 0; i + sz < n; i += sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] cache = new int[r - l + 1];
        for (int i = 0, j = l; i < cache.length; i++, j++) {
            cache[i] = arr[j];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = cache[j - l];
                j++;
            } else if (j > r) {
                arr[k] = cache[i - l];
                i++;
            } else if (cache[i - l] < cache[j - l]) {
                arr[k] = cache[i - l];
                i++;
            } else {
                arr[k] = cache[j - l];
                j++;
            }
        }
    }
}
