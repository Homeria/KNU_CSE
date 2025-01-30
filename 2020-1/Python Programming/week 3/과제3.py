dict1 = {}
subject = ""
score = 0
sumValue = 0

for i in range(0, 4):
    subject = (input("과목을 입력하시오 : "))
    score = int((input("%s의 점수를 입력하시오 : " %subject)))
    dict1[subject] = score

subject = list(dict1.keys())

for j in range(0, 4):
    print("dict1[%s] : %d" %(subject[j], dict1[subject[j]]))
    sumValue += dict1[subject[j]]
    

average = sumValue / 4

print("=" * 20)
print("평균은 %f점이다." %average)

