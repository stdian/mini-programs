
vowels = ['a', 'e', 'i', 'o', 'u', 'y']

text = 'simple text'
g = []
n = []

for i in text:
	if i in vowels:
		g.append(i)
		n.append(text.index(i))

g.reverse()
newText = list(text)


for i in range(len(g)):
	newText[n[i]] = g[i]

text = ''.join(newText)

print(text)