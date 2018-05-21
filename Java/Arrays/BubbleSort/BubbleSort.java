
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = {1,4,2,4,5,3,5,7,3};

		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}

		System.out.println(Arrays.toString(arr));

	}

	public static void swap(int[] arr, int i, int j) {
		int a = arr[i];
		arr[i] = arr[j];
		arr[j] = a;
	}
}
