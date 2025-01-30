# korean이 dict1의 key에 존재하는가, 또는 korean이 빈 값인가를 구별하는 함수
def judgeExitOrError(dict1, korean):
    
    if korean == '':
        return False
        
    if korean not in dict1.keys():
        raise KeyError

    return True


# 입력받은 key인 korean에 맞는 Value값을 입력받는 함수
def inputValue(dict1, korean):
    print('%s is not in dictionary key' % korean)
    eng = input("please input a english of %s : " % korean)
    dict1[korean] = eng
    print("dict1[\'%s\'] : \'%s\'" % (korean, eng))
    return dict1


dict1 = {'사과' : 'Apple', '체리' : 'Cherry', '멜론' : 'Melon', '바나나' : 'Banana'}

while True:
    try:
        korean = input("한글 과일을 입력하시오 : ")
        flag = judgeExitOrError(dict1, korean)
        if (flag == False):
            break
            
    except KeyError:
        dict1 = inputValue(dict1, korean)
        
        
    else:
        print(dict1[korean])







