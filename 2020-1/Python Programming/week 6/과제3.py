import turtle
t = turtle.Turtle()
t.shape("turtle")

num = int(turtle.textinput("", "몇각형을 원하시나요"))

for i in range(0, num):
    t.forward(100)
    t.left(360 / num)
