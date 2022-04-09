import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {32, 4, 1, -5, 6};
        sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }


    private static void sort(int[] arr) {
        //每次都向前循环，找到该位置应该插入的位置
        for (int i = 1; i < arr.length; i++) {
            int comp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                //去掉交换的优化
                if (comp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[++j] = comp;
        }
    }

//    private static void sort(int[] arr) {
//        //每次都向前循环，找到该位置应该插入的位置
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (arr[j + 1] < arr[j]) {
//                    int temp = arr[j + 1];
//                    arr[j + 1] = arr[j];
//                    arr[j] = temp;
//                } else {
//                    break;
//                }
//            }
//        }
//    }
}
