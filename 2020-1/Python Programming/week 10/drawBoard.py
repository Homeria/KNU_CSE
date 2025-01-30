# 빙고보드를 그리는 함수
def drawBoard(list1, n):
    print("")
    print(" _" * n)
    for i in range(0, n):
        for j in range(0, n):
            print("|", end = "")
            print(list1[i][j], end = "")
        print("|")
