import game

while True:
    flag = True
    print('=' * 10 + 'START!' + '=' * 10)
    try:
        p1 = input("Player1 [가위, 바위, 보] : ")
        p2 = input("Player2 [가위, 바위, 보] : ")
        winner = game.rps(p1, p2)
    except ValueError:
        print('잘못된 값을 넣었습니다!')
        flag = False
    finally:
        if flag:
            if winner == 'DRAW!':
                print("We have no winner!")
            else:
                print("Winner is [%s]" %winner)
        else:
            print("Oops! Arguments are strange['가위', '바위', '보']")
    print('=' * 26)
