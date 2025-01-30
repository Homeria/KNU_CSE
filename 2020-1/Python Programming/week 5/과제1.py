name = input("학생의 이름을 입력하시오 : ")
score = int(input("%s 학생의 성적을 입력하시오 : " %name))

if score >= 90:
    print("%s 학생의 성적은 A학점이다." %name)
elif score >= 80:
    print("%s 학생의 성적은 B학점이다." %name)
elif score >= 70:
    print("%s 학생의 성적은 C학점이다." %name)
elif score >= 60:
    print("%s 학생의 성적은 D학점이다." %name)
else:
    print("%s 학생의 학점은 F학점이다." %name)
