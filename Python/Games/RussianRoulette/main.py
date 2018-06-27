
import turtle
import random
import math

PHI = 360 / 7
R = 50

def fillcircle(color, r):
    turtle.fillcolor(color)
    turtle.begin_fill()
    turtle.circle(r)
    turtle.end_fill()

def circle(r):
    turtle.circle(r)

def gotoxy(x, y):
    turtle.penup();
    turtle.goto(x, y)
    turtle.pendown()

turtle.speed(0)

def draw_pistol(base_x, base_y):
    gotoxy(base_x, base_y)
    circle(80)
    gotoxy(base_x, base_y + 160)
    fillcircle('red', 5)

    for i in range(0, 7):
        phi_rad = PHI * i * math.pi / 180.0
        gotoxy(base_x + math.sin(phi_rad) * R, base_y + math.cos(phi_rad) * R + 60)
        fillcircle('white', 22)

def rotate_pistol(base_x, base_y ,start):
    for i in range(start, random.randrange(7, 100)):
        phi_rad = PHI * i * math.pi / 180.0
        gotoxy(base_x + math.sin(phi_rad) * R, base_y + math.cos(phi_rad) * R + 60)
        fillcircle('brown', 22)
        fillcircle('white', 22)
    gotoxy(base_x + math.sin(phi_rad) * R, base_y + math.cos(phi_rad) * R + 60)
    fillcircle('brown', 22)

    return i % 7

def main():
    draw_pistol(100, 100)

    do = ''
    start = 0
    while do != "n":
        do = turtle.textinput("(y/n)", "Go play? (y/n)")
        if do == 'y':
            start = rotate_pistol(100, 100, start)

            if start == 0:
                gotoxy(-150, 250)
                turtle.write("You was die))", font=("Arial", 18, "normal"))


if __name__ == '__main__':
    main()