var arr = [3,445,3,654,6,4568,5479,46,3456,2357,368,45,367,248,357,935,687346,835];

function bubbleSort(a) {
	for (var i = arr.length - 1; i > 0; i--) {
		for (var j = 0; j < i; j++) {
			if (arr[j] > arr[j + 1]) {
				swap(arr, j, j + 1);
			}
		}
	}
}

function swap(arr, i, j) {
	var a = arr[i];
	arr[i] = arr[j];
	arr[j] = a;
}


bubbleSort(arr);
alert(arr)