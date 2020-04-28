#CSC 110 December 4, 2018 Assignment 6
#Jordan Carlson V00714886
#December 4, 2018

import Die
import SL_Board
import Player

def main():
	# Your code goes here
	
	print( '\n\nSNAKES AND LADDERS\n')			#Title of program
	print('The board:')		#Introduces the board
	print(boardData())			#prints the board
	

	player_1 = Player.Player()	#sets a variable for player 1 from the player class
	player_2 = Player.Player()	#sets a variable for player 2 from the player class
	
	
	player_1.set_symbol()		#gives player 1 a symbol from the player class
	player_2.set_symbol()		#gives player 2 a symbol from the player class
	
	player_1.set_name('Quinn')	#sets Quinn as the name for player 1
	player_2.set_name('Aaron')	#sets Aaron as the name for player 2

	
	while player_1.get_symbol() == player_2.get_symbol():	#checks if the symbol is the same for both players
		player_1.set_symbol()	#changes the symbol of player one to ensure different symbols
		

	
	print('Player 1 = ', player_1.__str__())	#prints the starting name and position for player 1
	print('Player 2 = ', player_2.__str__())	#prints the starting name and position for player 2

	boardinput = boardData()	#creates a variable for the boardData function
	
	move = 0	#starts who's move it is at 0
	
	roll = Die.Die()	#uses the die roll class for die rolls
		
	while player_1.get_position() < 36 and player_2.get_position() < 36:	#while loop to continue moving until someone has won
		roll.throw()				#rolls the die
		
		move += 1					#adds one to the move parameter
		
		if move % 2 != 0:			#partitions the move to first player's turn

			startposition = player_1.get_position()		#puts the initial position of the turn in a variable
			player_1.set_position (startposition + roll.get_faceUp())	#adds the roll value to the initial position
			
			if (player_1.get_position() > 35):	#checks if the roll is above the moving square
				player_1.set_position(36)		#brings player to the winning square if they have won
							#prints the player's position
								#keeps the code running without error
				
			elif boardinput.is_snake(player_1.get_position()):				#looks for a snake in the board
				player_1.set_position(boardinput.get_snake_tail(player_1.get_position())) 	#brings the player to the bottom of the tail
								#keeps the code running without error
			elif boardinput.is_ladder(player_1.get_position()):			#looks for a ladder in the board
				player_1.set_position(boardinput.get_ladder_top(player_1.get_position()))	#brings the player to the top of the ladder

			print(player_1.__str__())	#prints the player's name, symbol, and position in style from player class
		
			
	
		else: 
		
			startposition = player_2.get_position()		#puts the initial position of the turn in a variable
			player_2.set_position( startposition + roll.get_faceUp())	#adds the roll value to the initial position
			if (player_2.get_position() > 35 ):	#checks if the roll is above the moving square
				player_2.set_position(36)		#brings player to the winning square if they have won
						
			
			elif boardinput.is_snake(player_2.get_position()):					#looks for a snake in the board
				player_2.set_position(boardinput.get_snake_tail(player_2.get_position()))	#brings the player to the tail of the snake
			elif boardinput.is_ladder(player_1.get_position()):				#looks for a ladder in the board
				player_2.set_position(boardinput.get_ladder_top(player_2.get_position()))	#brings the player to the top of the ladder
			print(player_2.__str__())			#prints the player's name, symbol, and position in style from player class

	if player_1.get_position() > 35:				#checks to see if player one is on the winning square

				print('WINNER', player_1.get_name(), player_1.get_symbol())		#prints player one's winning information
					
	if player_2.get_position() > 35:				#checks to see if player two is on the winning square

				print('WINNER', player_2.get_name(), player_2.get_symbol())		#prints player two's winning information
								
	
	
		
#Add and document suitable functions

#This function can be called in your program. 	
def boardData():
	with open("boardConfig.txt","r") as fileHandle:
		size = int(fileHandle.readline().strip("\n"))
		snakeData = fileHandle.readline().split()
		for i in range(len(snakeData)):
			snakeData[i] = int(snakeData[i].strip("\n"))
		ladderData = fileHandle.readline().split()
		for i in range(len(ladderData)):
			ladderData[i] = int(ladderData[i].strip("\n"))
		
		# Convert snakes to a list of tuples
		snakes = []
		for i in range(0,len(snakeData)//2):
			snakes.append( (snakeData[2*i], snakeData[2*i+1]) )
		
		# Convert ladders to a list of tuples
		ladders = []
		for i in range(0,len(ladderData)//2):
			ladders.append( (ladderData[2*i], ladderData[2*i+1]) )
		newBoard = SL_Board.SL_Board(size,snakes,ladders)
		return newBoard

# Do not change anything below here. 		
if __name__ == "__main__":
	main()