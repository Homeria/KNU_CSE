def rps(p1, p2):
    if (p1 == p2):
        winner = 'DRAW!'
    elif (p1 == '가위' and p2 == '바위') or (p1 == '바위' and p2 == '보') or (p1 == '보' and p2 == '가위'):
        winner = 'p2'
    else:
        winner = 'p1'
    return winner
