var arr = [3,5,6,8,11,33,52,72,75,76,94,82,88,100,102];

function search(arr, value) {
	var size = arr.length
	var low = 0
	var high = size - 1
	var isFounded = false;

	while (low <= high) {
		var mid = Math.round((low + high) / 2)

		if (value == arr[mid]) {
			alert("Value " + value + " at index " + mid)
			isFounded = true
			break
		}
		else if (value > arr[mid]) {
			low = mid + 1
		}
		else {
			high = mid - 1
		}
	}

	if (isFounded == false) {
		alert("Value " + value + " not found")
	}
}

search(arr, 11);