value = int(input("정수를 하나 입력하세요 : "))

if (value % 2) == 0 and (value % 3) == 0:
    print("%d는 2와 3으로 나누어진다," %value)
elif (value % 2) == 0:
    print("%d는 2로 나누어진다." %value)
elif (value % 3) == 0:
    print("%d는 3으로 나누어진다." %value)
else:
    print("%d는 2와 3으로 나누어지지 않는다." %value)
