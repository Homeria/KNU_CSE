name = input("학생의 이름을 입력하시오 : ")
korScore = int(input("국어 점수 : "))
mathScore = int(input("수학 점수 : "))
socialScore = int(input("영어 점수 : "))
scienceScore = int(input("과학 점수 : "))
avg = int((korScore + mathScore + socialScore + scienceScore) / 4)
print(name, "학생의 평균은 ", avg, " 입니다.")
