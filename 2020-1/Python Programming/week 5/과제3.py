num1 = input("첫 번째 정수를 입력하세요(10 ~ 99) : ")
num2 = input("두 번째 정수를 입력하세요(10 ~ 99) : ")

if (num1[0] == num2[1] and num1[1] == num2[0]):
    print("%s, %s : 두 개의 숫자가 일치하지만 자리 값은 다른 정수입니다." %(num1, num2))

elif ((num1[0] != num2[0] and num1[1] != num2[1]) and (num1[0] == num2[1] or num1[1] == num2[0])):
    print("%s, %s : 자리 값이 다르고, 하나의 숫자만 일치합니다." %(num1, num2))

elif (num1[0] == num2[0] or num1[1] == num2[1]):
    print("%s, %s : 자리 값이 같고 하나의 숫자가 일치합니다." %(num1, num2))
    
else:
    print("%s, %s :일치하는 숫자가 없습니다." %(num1, num2))

