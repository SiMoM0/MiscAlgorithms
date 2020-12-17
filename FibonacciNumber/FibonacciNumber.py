#Find the n number of FIbonacci sequence
num = int(input("Insert Number: "))

def fibonacci(n):
	if(n<2):
		return n
	return fibonacci(n-2) + fibonacci(n-1)

print(fibonacci(num))
