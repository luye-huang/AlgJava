import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 16, 4, 7};
        sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void sort(int[] arr) {
        //每次都找到第几小的
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i], index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= min) {
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
