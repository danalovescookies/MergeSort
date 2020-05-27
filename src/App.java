import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void merge(int[] left, int[] right, int[] arr){
        int i = 0;
        int j = 0;
        while (i + j < arr.length){
            if (j == right.length || (i < left.length && left[i] < right[j])){
                arr[i + j] = left[i];
                i += 1;
            }
            else {
                arr[i + j] = right[j];
                j += 1;
            }
        }
    }
    public static void mergeSort(int[] arr){
        if (arr.length < 2){
            return;
        }
        int middle = arr.length/2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter number of integers:");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        mergeSort(a);
        System.out.println("Sorted numbers: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
