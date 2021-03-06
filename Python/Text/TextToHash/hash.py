
import hashlib
import os


def main():
	result = None

	os.system('cls')
	text = input('Input text: ')
	
	print('Choose hash type:')
	print()
	print('1. MD5')
	print('2. SHA256')
	hash_type = int(input())

	if hash_type == 1:
		result = hashlib.md5(text.encode("utf")).hexdigest()
		print('Result: ' + result)
	elif hash_type == 2:
		result = hashlib.sha256(text.encode("utf")).hexdigest()
		print('Result: ' + result)


if __name__ == '__main__':
	main()