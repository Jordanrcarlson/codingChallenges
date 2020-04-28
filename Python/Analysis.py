#CSC 110 201809 Assignment 5
#Jordan Carlson V00714886
#November 21, 2018



def wordTotal(wordlist):		# Input: a 1 dimensional list of words
							# Returns: an integer, the number of words
							
	wordcount = 0				#starts word count at zero
	for words in wordlist:		#loop to restart at each item in list of words
		wordcount += 1			#adds one to the count for each word
	
	return wordcount			#returns the word count back to the main function
	

def wordFrequency(wordlist):		# Input: a 1 dimensional list of words
								# Returns: a dictionary with key = word (string)
								# and value = number of occurrences
	wordfrequencyresult = {}	#creates dictionary holding words and their frequencies
	for words in wordlist:		#loops for each item in list of words
		words = words.lower()		#turns all characters to lowercase as count is not case sensitive
		if words in wordfrequencyresult.keys():		#finds word repition in dictionary keys
			wordfrequencyresult[words] += 1			#adds one to the count for additional words in dictionary key
		else:
			wordfrequencyresult[words] = 1		#keeps individual word count at one for no repeat words
	return wordfrequencyresult		#returns the individual word frequency back to the main function
								
def letterCount(wordlist):		# Input: a 1 dimensional list of words
								# Returns: two integers: count of lower case letters
								# and count of upper case letters
	lowercase = 0				#starts lowercase letter count at zero
	uppercase= 0				#starts uppercase letter count at zero
	
	for letters in wordlist:	#reiterates loop for each letter in list of letters
		if letters.islower():	#divides the loop's addition to lowercase
			lowercase += 1		#adds one to the count for each lowercase letter
		elif letters.istitle():	#divides the loop's addition to uppercase
			uppercase += 1		#adds one to the count for each uppercase letter
	return lowercase, uppercase	#returns the letter count back to the main function
								
def letterFrequency(wordlist):	# Input: a 1 dimensional list of words
								# Returns: a dictionary with key = alpha-numeric
								# letters and value = number of occurrences
								# Do not change *anything* below this line
	letterfrequencyresult={}	#creates a dictionary for letters as keys and values as counts
	for letters in wordlist:	#iterates a loop for each letter
		if letters in letterfrequencyresult.keys():	#finds word repitition in dictionary keys
			letterfrequencyresult[letters] += 1		#adds one to the count for repeat words
		else:
			letterfrequencyresult[letters] = 1		#keeps count at one for no repeat words
	return letterfrequencyresult	#returns the individual letter frequency back to the main function

def main ():					#Main function

	storyfile = open("storyIn.txt", "r")				#opens file with matrix parameters to create matrix
	outputfile = open("analysisOut.txt", "w")		#creates file to write the outputs of the created matrices

	wordline = []				#creates a list to seperate lines into words
	letterlist = []				#cretes a list for individual letters
	
	for linelist in storyfile:

		linelist = linelist.strip()		#strips blank spaces from list
		linelist = linelist.strip('\n')		#strips newline characters from list of lines
	
		letterline = [index for index in linelist] 		#breaks list up into letters
		linelist = linelist.split(' ')				#divides the letters by splitting from blank spaces
		
		for letters in letterline:
			if letters != '' and letters != ' ' and letters != '.' and letters != ',' and letters != '?' and letters != '!' and letters != ';' and letters != ':' and letters != '(' and letters != ')':
										#removes blankspaces and symbols from list of letters
				letterlist.append(letters) 	#adds letters to the list
										
		for words in linelist:				#begin to divide the lines into words
			if (words != ''):				#removes extra blankspaces
				words = words.strip('.')		#removes symbols
				words = words.strip(',')		#removes symbols
				words = words.strip('?')		#removes symbols
				words = words.strip('!')		#removes symbols
				words = words.strip(';')		#removes symbols
				words = words.strip(':')		#removes symbols
				words = words.strip('(')		#removes symbols
				words = words.strip(')')		#removes symbols
				wordline.append(words)		#puts individual words into list
				
	wordcount = wordTotal(wordline)							#sends the line of words to the total word count function
	wordfrequencyresult = wordFrequency(wordline)			#sends the line of words to the individual word count function
	lowercase,uppercase = letterCount(letterlist)			#sends the line of letters to the total letter count function
	letterfrequencyresult = letterFrequency(letterlist)		#sends the line of letters to the individual letter count function 
	
	outputfile.write("Words" + ':' + str(wordcount) + "\n")		#writes the result of the total word count to the output file

	for wordelements in sorted(wordfrequencyresult):					#loop iterates for each element in the individual word count dictionary
		outputfile.write(str(wordfrequencyresult[wordelements]) + ': ' + wordelements + '\n')		#writes elements to the output file
	outputfile.write("Upper Case Letters: " + str(uppercase) + '\n') #writes the result of the uppercase letter count to the output file
	outputfile.write('Lower Case Letters: ' + str(lowercase) + '\n')	#writes the result of the lowercase count to the output file
	
	for letterelements in sorted(letterfrequencyresult):			#loop iterates for each element in the individual letter count dictionary
		outputfile.write(letterelements +': '+ str(letterfrequencyresult[letterelements]) + '\n')	#writes the result of the individual letter count to the output file
		
	storyfile.close()							#closes the input file

# Do not change *anything* below this line
if __name__ == "__main__":
	main()
	