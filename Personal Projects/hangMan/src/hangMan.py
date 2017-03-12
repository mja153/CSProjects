import drawHangman
import turtle
import random


def main():
 

    window = turtle.Screen()
    window.setup(400, 400, 200, 200)
    HG = turtle.Turtle()
    drawHangman.default(HG)


    wordList = open("..\data\mywordlist.txt", 'r')
    words = []

    guessedLetters = []

    def replayGamePrompt():
        replayInput = input(str("Do you want to play again? Enter y to play again or anything else to quit. "))
        if replayInput.lower() == "y":
            game(True)
        else:
            quit()  
    
    # Runs when user guesses wrong 6 times, draws the final leg of the hang man program and asks the user if they want to play again.
    def lastFailure(victoryWord):
        drawHangman.drawLeftLeg(HG)
        print ("You lose! The correct word was:",victoryWord)
        replayGamePrompt() 

    # Error handling for the users guess, checks to see if the input is a letter a-z, and has not been guessed already
    def guessLetter():
        while True:
            guess = input("Input your guess: ").lower()
            if len(guess) != 1:
                print ("Please input only a single letter.")
            elif not guess.isalpha():
                print ("Please only enter a letter.")
            elif guess in guessedLetters:
                print ("Please input a letter you haven't already guessed.")
            else:
                return guess

    hangmanAction = {
        1: lambda: drawHangman.drawHead(HG),
        2: lambda: drawHangman.drawBody(HG),
        3: lambda: drawHangman.drawRightArm(HG),
        4: lambda: drawHangman.drawLeftArm(HG),
        5: lambda: drawHangman.drawRightLeg(HG),
        6: lastFailure
    }
    
    for line in wordList:
        words.extend(line.split())  

    # Main loop, allowing the user to have 6 incorrect guesses. Once they have consumed those, they lose the game, or if they complete the answer, they win
    def game(reset):
        # Reset the hangman
        if reset:
            drawHangman.reset(HG)
        guessedLetters = []
        # The randomly selected victory word for the game
        victoryWord = random.choice(words).lower()
        # We represent the un-guessed letters with '-'
        answerKey = "-" * len(victoryWord)
    
        correctLetters = []
        wrongLetters = []
        incorrectGuesses = 0
    
        while incorrectGuesses < 6:
            guessedLetter = guessLetter()
            guessedLetters.append(guessedLetter)
            if guessedLetter in victoryWord:
                correctLetters.append(guessedLetter)
                print ("Correct! Your guess", guessedLetter, "is a correct letter!")
                            
                # Generates the answer key for the guessed letters
                for i, char in enumerate(victoryWord):
                    if char in correctLetters:
                        answerKey = answerKey[:i] + char + answerKey[i+1:]
                
                # Checks if the the user has completed the word, if he has it asks him if he wants to restart the game.
                if answerKey == victoryWord:
                    print ("You won! Congratulations on guessing the word", victoryWord + "!")
                    replayGamePrompt()
            else:
                # Adds the wrong guess to the wrong letters list, increases hang man counter by 1 and executes next hang man action.
                wrongLetters.append(guessedLetter)
                print ("Incorrect! Your guess",guessedLetter,"is not a correct letter. Try again!")
                incorrectGuesses += 1
                if incorrectGuesses == 6:
                    hangmanAction[incorrectGuesses](victoryWord)
                else:
                    hangmanAction[incorrectGuesses]()

            print ("Current word: ", answerKey)
            print ("Incorrect letters: ", wrongLetters)
    # Start first game!
    game(False)
    
    # End of the main function
main()


