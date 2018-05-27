
def search(arr, value):

	size = len(arr)
	low = 0
	high = size - 1

	while low <= high:
		mid = (low + high) // 2

		if value == arr[mid]:
			print('Value ' + str(value) + ' at index ' + str(mid))

			break
		elif value > arr[mid]:
			low = mid + 1
		else:
			high = mid - 1
	else:
		print('Value ' + str(value) + ' not found')

arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
search(arr, 3)
