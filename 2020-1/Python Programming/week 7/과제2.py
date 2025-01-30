def fib(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    return fib(n-2) + fib(n-1)

num = int(input("입력 : "))

for i in range(num + 1):
    print("fib(%s) : %s" %(i, fib(i)))
