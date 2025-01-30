# 빙고판의 사이즈를 체크하는 함수
def sizeJudge(n):
    flag = True
    if n < 2:
        print("[Error] The size is too small. Try again.\n")
        flag = False
    return flag


# 좌표의 적절성을 파악하는 함수
def coordinateJudge(boardList, x, y, n):
    if (x < 1) or (y < 1):
        print("[Error] The number is too small.")
        raise ValueError
    elif (x > n) or (y > n):
        print("[Error] The number is too big.")
        raise ValueError
    elif (boardList[x-1][y-1] != " "):
        print("[Error] Space is not empty.")
        raise ValueError
    


# 빙고판이 가득 찼는지 판별하는 함수
def fullBoardJudge(list1, n):
    flag = True
    num = 0
    for i in range(0, n):
        for j in range(0, n):
            if list1[i][j] != " ":
                num += 1
    if num == (n * n):
        print("Can't move anymore.")
        flag = False
    return flag


    
