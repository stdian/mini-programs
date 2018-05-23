
public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = i*3;
		}

		search(arr, 27);
	}

	public static void search(int[] arr, int value) {

		int size = arr.length;
		int low = 0;
		int high = size - 1;
		Boolean isFounded = false;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (value == arr[mid]) {
				System.out.println("Value " + value + " at index " + mid);
				isFounded = true;
				break;
			}
			else if (value > arr[mid]) {
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
