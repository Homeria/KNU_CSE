subject = []
score = []
sumValue = 0

for i in range(0, 4):
    subject.append(input("과목을 입력하시오 : "))
    score.append(input("%s의 점수를 입력하시오 : " %subject[i]))

for j in range(0, 4):
    print("%s 점수는 %d점 이다." %(subject[j], int(score[j])))
    sumValue += int(score[j])
    

averageValue = sumValue / 4

print("=" * 20)
print("평균은 %f점이다." %averageValue)
