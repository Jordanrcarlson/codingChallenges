#CSC 110 Assignment 6
#Jordan Carlson V00714886
#December 4, 2018


import random				#imports the random class to choose player letter
import Die					#imports the class Die from Die.py

class Player:			#initializes the Player class

	def __init__(self): #Initializes the data attributes
	
		self.__name = str('')			#Initalizes the name attribute
		self.__symbol = str('')		#Initalizes the symbol attribute
		self.__position = 1		#Initalizes the position attribute

	def set_symbol(self):		#changes the self._symbol to a random letter

		alphabet='abcdefghijklmnopqrstuvwxyz'		#collects alphabet to a string
		self.__symbol= random.choice(alphabet)	#chooses a random letter in the alphabet
		
	def set_name( self, name): #sets the self.__name attribute
		self.__name = name		#changes the attribute self.__name to the parameter passed as 'name'
			
	def get_name(self):	#returns the value of the self.__name attribute
	
		return self.__name	#returns self.__name
		
	def get_symbol(self): #returns the value of the self__symbol attribute
	
		return self.__symbol	#returns self.__symbol

	def set_position(self, position): #sets the self.__position attribute
	
		self.__position = position  #changes the attribute self.__position to the parameter passed as 'position'

	def get_position(self):			#returns the current value of the self.__position
	
		return self.__position		#returns self.__position

	def __str__(self):			#returns a string that contains the current value of each of the three attributes in the following format
	
		return self.__name + ' (' +  self.__symbol + '): ' + str(self.__position)		#returns the __str__ attribute