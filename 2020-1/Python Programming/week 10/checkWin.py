# 가로로 줄을 채웠을 때의 승패 결정
def rowsCheckWin(boardList, n, player):
    win = 0
    valueList = []
    for i in range(0, n):
        if player == 1:
            valueList.append("X")
        elif player == 2:
            valueList.append("O")
        else:
            print("[Error] rowsCheckWin - player")
            
    if valueList in boardList:
        if player == 1:
            win = 1
        elif player == 2:
            win = 2
        else:
            print("[Error] valueList in boardList - Player")

    return win


# 세로로 줄을 채웠을 때의 승패 결정
def colsCheckWin(boardList, n, player):
    num = 0
    win = 0
    for i in range(0, n):
        for j in range(0, n):
            if player == 1:
                if boardList[j][i] == "X":
                    num += 1
            elif player == 2:
                if boardList[j][i] == "O":
                    num += 1
            else:
                print("[Error] colsCheckWin - player")
        if num == n:
            if player == 1:
                win = 1
            if player == 2:
                win = 2
            break
        
        num = 0
        
    return win


# 대각선으로 줄을 채웠을 때의 승패 결정
def diagonalWin(boardList, n, player):
    num = 0
    win = 0
    for i in range(0, n):
        if player == 1:
            if boardList[i][i] == "X":
                num += 1
        elif player == 2:
            if boardList[i][i] == "O":
                num += 1
        else:
            print("[Error] diagonalWin - player")
            
    if num == n:
        if player == 1:
             win = 1
        if player == 2:
             win = 2


    if win == 0:
        num = 0
        x = n - 1
        for i in range(0, n):
            if player == 1:
                if boardList[i][x] == "X":
                    num += 1
            elif player == 2:
                if boardList[i][x] == "O":
                    num += 1
            x -= 1
            
        if num == n:
            if player == 1:
                win = 1
            if player == 2:
                win = 2
                
    return win
    

# 가로, 세로, 대각선을 채웠을 때의 승패 결정 합
def checkWin(boardList, n, player):
    win = 0
    if win == 0:
        win = rowsCheckWin(boardList, n, player)
    if win == 0:
        win = colsCheckWin(boardList, n, player)
    if win == 0:
        win = diagonalWin(boardList, n, player)

    return win
