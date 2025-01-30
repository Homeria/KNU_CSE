# 2차원 리스트를 만드는 함수
def makeList(n):
    boardList = []
    for i in range(0, n):
        boardList.append([])
        for j in range(0, n):
            boardList[i].append(" ")
    return boardList

# 2차원 리스트의 오류 여부를 따지기 위해 2차원 리스트 출력하는 함수
def printList(list1, n):
    for i in range(0, n):
        print(list1[i])
        print("*")


