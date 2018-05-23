
import java.util.Arrays;
import java.util.Random;

public class BinarySearchWithBubbleSort {

	public static void main(String[] args) {

		Random random = new Random();

		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = random.nextInt(10);
		}

		System.out.println(Arrays.toString(array));

		array = sort(array);

		System.out.println(Arrays.toString(array));

		search(array, 3);
	}

	public static int[] sort(int[] array) {

		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					array = swap(array, j, j + 1);
				}
			}
		}

		return array;
	}

	public static int[] swap(int[] array, int i, int j) {
		int a = array[i];
		array[i] = array[j];
		array[j] = a;
		return array;
	}

	public static void search(int[] array, int value) {

		int size = array.length;
		int low = 0;
		int high = size - 1;
		Boolean isFounded = false;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (value == array[mid]) {
				System.out.println("Value " + value + " at index " + mid);
				isFounded = true;
				break;
			}
			else if (value > array[mid]) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}

		if (isFounded == false) {
			System.out.println("Value " + value + " not found");
		}

	}

}
