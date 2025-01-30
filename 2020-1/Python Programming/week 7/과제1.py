import turtle

def n_polygon(pen, n, length):
    for i in range(n):
        pen.forward(length)
        pen.left(360 / n)

    

t = turtle.Turtle()
t.shape('turtle')

for i in range(10):
    t.left(20)
    n_polygon(t, 6, 100) 
