breads = ["허니오트", "위트", "화이트"]
vegi = ["양상추", "토마토", "올리브"]
meat = ["소고기", "돼지고기", "닭고기"]
sauce = ["마요네즈", "꿀", "칠리"]

for i in range(0, 3):
    for j in range(0, 3):
        for p in range(0, 3):
            for q in range(0, 3):
                print("%s + %s + %s + %s" %(breads[i], vegi[j], meat[p], sauce[q]))
                if q == 2:
                    print("\n")
