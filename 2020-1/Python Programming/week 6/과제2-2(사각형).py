import turtle
t = turtle.Turtle()
t.shape("turtle")

color_list = ["blue", "red", "yellow", "black"]

for i in range(0, 4):
    t.fillcolor(color_list[i])
    t.begin_fill()
    for j in range(0, 4):
        t.forward(100)
        if j != 3:
            t.left(90)
    t.end_fill()
    t.left(180)
    t.forward(100)
