#CSC 110 Assignment 6
#Jordan Carlson V00714886
#December 4, 2018

import random		#imports random class to choose random number for die throw

class Die:		#defines the methuds for the __faceUp attribute

	def __init__(self):		#initializes the self.__faceUp method
	
		self.__faceUp = 0		#initializes self.__faceUp at zero

	def throw(self):			#Creates throw method

		number = random.randint(1, 6)	#creates a variable for a random number between one and six
		self.__faceUp = number			#

	def get_faceUp(self):	#returns faceUp method
	
		return self.__faceUp		#returns current value of self.faceUp