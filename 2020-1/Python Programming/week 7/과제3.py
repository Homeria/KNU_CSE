import random

def filtering(n):
    for j in range(n):
        if list1[j] > 5:
            list2.append(list1[j])
    return list2

list1 = list()
list2 = list()
n = 100
for i in range(n):
        list1.append(random.randint(0, 10))
print("=" * 25, "list1", "=" * 25)
print(list1)
print("=" * 25, "list2", "=" * 25)
print(filtering(n))
