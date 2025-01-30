primeNum = open("primenumbers.txt", "r")
happyNum = open("happynumbers.txt", "r")
primeNumList = []
happyNumList = []

for line in primeNum:
    primeNumList.append(line.rstrip())
primeNum.close()

for line in happyNum:
    happyNumList.append(line.rstrip())
happyNum.close()

for i in range(0, len(primeNumList)):
    if(primeNumList[i] in happyNumList):
        print('%d, ' %int(primeNumList[i]), end = '')

    
