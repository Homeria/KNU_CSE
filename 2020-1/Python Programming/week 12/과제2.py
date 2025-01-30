from tkinter import*

def changeFahrenheit():
    temperature = float(e1.get())
    mytemp = (temperature - 32) * 5 / 9
    e2.insert(0, str(mytemp))

def changeCentigrade():
    temperature = float(e2.get())
    mytemp = temperature * 1.8 + 32
    e1.insert(0, str(mytemp))




window = Tk()

l1 = Label(window, text = "화씨", font = 'helvetica 16 italic')
l1.grid(row = 0, column = 0)

l2 = Label(window, text = "섭씨", font = 'helvetica 16 italic')
l2.grid(row = 1, column = 0)

e1 = Entry(window, bg = "yellow", fg = "red")
e1.grid(row = 0, column = 1)
e2 = Entry(window, bg = "yellow", fg = "red")
e2.grid(row = 1, column = 1)

b1 = Button(window, text = "화씨 -> 섭씨", command = changeFahrenheit)
b1.grid(row = 2, column = 0)
b2 = Button(window, text = "섭씨 -> 화씨", command = changeCentigrade)
b2.grid(row = 2, column = 1)

window.mainloop()





