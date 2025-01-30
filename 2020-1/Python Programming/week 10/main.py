# 2차원 리스트를 만들기 위한 모듈
import makeList
# 오류를 판단하거나 빙고판이 가득 찼는지 판단하기 위한 모듈
import judgeError
# 빙고판을 그리기 위한 모듈
import drawBoard
# 우승을 판별하기 위한 모듈
import checkWin
# 랜덤 함수 위한 모듈
import random


# 빙고판 사이즈 결정
while True:
    try:
        flag = True
        size = int(input("Please input the size of the game board(more than 2) : "))
        flag = judgeError.sizeJudge(size)
        
    except ValueError:
        print("Value Error. Try again\n")
        
    else:
        if flag == True:
            print("The Value is not Error. Pass")
            break


# 변수 선언 및 빙고판 그리기
boardList = makeList.makeList(size)
player = 1
win = 0
drawBoard.drawBoard(boardList, size)


# 메인
while True:
    flag = True

    try:
        flag = judgeError.fullBoardJudge(boardList, size)
        if flag == False:
            break

        print("Currently player : %d" %player)

        if player == 1:
            x = int(input("Which row? (start with 1) "))
            y = int(input("Which column? (start with 1) "))
        elif player == 2:
            x = random.randint(0, size)
            y = random.randint(0, size)
        judgeError.coordinateJudge(boardList, x, y, size)

    except ValueError:
        print("Try again.\n")


    else:
        if flag == True:
            if player == 1:
                 boardList[x-1][y-1] = "X"
                 win = checkWin.checkWin(boardList, size, player)
                 player = 2
            elif player == 2:
                 boardList[x-1][y-1] = "O"
                 win = checkWin.checkWin(boardList, size, player)
                 player = 1
            else:
                 print("playerError")
                 break

            drawBoard.drawBoard(boardList, size)
        
            if win == 1:
                print("player 1 win")
                break
            if win == 2:
                print("player 2 win")
                break
    
    
    


