import pickle


testBinary = open("test.dat", "wb")
testRB = open("test.dat", "rb")
testList = []

while True:
    data = input("데이터를 입력하시오(종료: -1) : ")
    if data == "-1":
        break
    else:
        testList.append(data)

pickle.dump(testList, testBinary)
testBinary.close()


obj = pickle.load(testRB)

for i in range(0, len(obj)):
    print(obj[i])

testRB.close()
