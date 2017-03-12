def default(drawHangman):
    # Start drawing stand
    drawHangman.penup()
    drawHangman.setpos(0, -50)
    drawHangman.pendown()
    drawHangman.back(100)
    drawHangman.fd(50)
    drawHangman.left(90)
    drawHangman.forward(175)
    drawHangman.right(90)
    drawHangman.forward(50)
    drawHangman.right(90)
    drawHangman.forward(25)
    drawHangman.right(90)
    # End drawing stand

def drawHead(drawHangman):
    drawHangman.pencolor("red")
    drawHangman.circle(15)
    drawHangman.penup()
    drawHangman.left(90)
    drawHangman.forward(30)
    drawHangman.pendown()

def drawBody(drawHangman):
    drawHangman.forward(65)
    drawHangman.back(40)
    drawHangman.right(90)

def drawRightArm(drawHangman):
    drawHangman.forward(30)
    drawHangman.right(180)
    drawHangman.forward(30)

def drawLeftArm(drawHangman):
    drawHangman.forward(30)
    drawHangman.back(30)


def drawRightLeg(drawHangman):
    # Move to lower body
    drawHangman.right(90)
    drawHangman.forward(40)
    # Draws the leg
    drawHangman.right(45)
    drawHangman.forward(40)
    drawHangman.right(180)
    drawHangman.forward(40)
    drawHangman.right(90)

def drawLeftLeg(drawHangman):
    drawHangman.forward(40)
    
def reset(drawHangman):
    drawHangman.reset()
    default(drawHangman)
