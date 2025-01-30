import turtle

# 최종적으로 그림 그리기
def draw_olympic_symbol(t):
    positions = [[0, 0, "blue"], [-120, 0, "purple"], [60, 60, "red"], [-60, 60, "yellow"], [-180, 60, "green"]]
    for x, y, c in positions:
        move(t, x, y)
        draw_circle(t, c)

# 원 그리기
def draw_circle(t, c):
    t.color(c, c)
    t.begin_fill()
    t.circle(30)
    t.end_fill()

# 좌표 이동하기
def move(t, x, y):
    t.penup()
    t.goto(x, y)
    t.pendown()

turtle = turtle.Turtle()
draw_olympic_symbol(turtle)
