inputMoney = int(input("투입한 돈 : "))
value = int(input("물건 값 : "))
change = inputMoney - value
print("거스름 돈 : %d" %change)

print("500원 동전 개수 : %d" %(change // 500))
change= change % 500
print("100원 동전 개수 : %d" %(change // 100))
change= change % 100
print("50원 동전 개수 : %d" %(change // 50))
change= change % 50
print("10원 동전 개수 : %d" %(change // 10))
