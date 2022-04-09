import java.util.Arrays;

public class QuickSort {
    // Q 求第几小的元素
    //数组有序时会退化，交换随机位置元素来解决
    //有大量重复元素时会退化，三路排序解决相等元素来解决
    public static void main(String[] args) {
        int[] arr = {32, 4, 1, -5, 6};
        sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sort(int[] arr, int l, int r) {
        if (r <= l) {
            return;
        }
        int indexSwap = l + (int) (Math.random() * (r - l));
        swap(arr, l, indexSwap);
        //int index = partition(arr, l, r);
        //[l, lt] 小于v， [gt, r]大于v
        int lt = l, gt = r + 1, i = l + 1;
        while (i < gt) {
            if (arr[i] > arr[l]) {
                gt--;
                swap(arr, i, gt);
            } else if (arr[i] < arr[l]) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }


    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
