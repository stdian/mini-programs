
def quicksort(array):
	if len(array) < 2:
		return array

	pivot = array[0]

	less = [i for i in array[1:] if i <= pivot]
	greater = [i for i in array[1:] if i > pivot]

	return quicksort(less) + [pivot] + quicksort(greater)


arr = [6, 8, 3, 2, 4, 9, 0, 1, 5, 7]
print(quicksort(arr))
