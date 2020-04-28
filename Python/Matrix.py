#CSC 110 Assignment 4
#Jordan Carlson V00714886
#November 9th, 2018

def MatrixIn(str):					#brings original file in to be manipulated

	if len(str) != 2:							#if statement do differentiate how to split characters
		str = str.strip().split(' ')				#splits the lines into individual characters
		NumbersInList = []						#Creates list from digits
		for i in str:
			NumbersInList.append(int(i))		#appends numbers to list
		twoDlist = []							#Creates second list in 2 dimensions from second set of digits
		for i in range(0, NumbersInList[0]):	#Loop to start picking out numbers from both dimensions
			row = []							#Loop to pick out numbers individually
			for j in range((i * NumbersInList[1]) + 2, (i * NumbersInList[1]) + 2 + NumbersInList[1] ):	#calls second dimension list numbers from first dimension
				row.append(NumbersInList[j])		#appends each individua number
			twoDlist.append(row)					#appends rows to both dimensions
		return twoDlist								#returns twoDlist to the main function
	else:
		numstr = str.strip()						#splits characters if len(str) = 2
		numint = int(numstr)						#turns numstr to an int type
		return numint								#returns numint instead of twoDlist to the main function

def addMatrix(one, theOther):					# returns a 2-dimensional list: the sum of one + theOther

	result = []									#starts a 2D list to eventually be returned as a result of the function
	for i in range(0, len(one)):
		row = []								#starts a list to seperate each row into elements
		for j in range(0, len(one[i])):
			row.append(one[i][j] + theOther[i][j])		#completes calculation
		result.append(row)
	return result

def subtractMatrix(one, theOther):				# returns a 2-dimensional list: the difference: one - theOther

	result= []
	for i in range(0, len(one)):
		row = []								#starts a list to seperate each row into elements
		for j in range(0, len(one[i])):
			row.append(one[i][j] - theOther[i][j])		#completes calculation
		result.append(row)
	return result

def scalarMultiply(scalar, matrix):				#returns the matrix product of (scalar value) * matrix

	result = []									#starts a 2D list to eventually be returned as a result of the function
	for i in range(0, len(matrix)):
		row = []								#starts a list to seperate each row into elements
		for j in range(0, len(matrix[i])):
			row.append(scalar * matrix[i][j])		#completes calculation
		result.append(row)
	return result						#returns the calculation tot the main function

def dot(one, theOther):					#returns the matrix dot product: one <dot> theOther

	firstrow = []						#creates list for the first row
	secondrow = []						#creates list for the second row
	for i in one:
		row = []						#creates list for row 1
		for j in i:
			row.append(j)
		firstrow.append(row)				#appends row to list
	for j in range(0, len(theOther[0])):
		row = []							#creates list for row 2
		for i in range(0, len(theOther)):
			row.append(theOther[i][j])
		secondrow.append(row)
	result = []										#starts a 2D list to eventually be returned as a result of the function
	for i in range(0, len(firstrow)):
		row = []									#starts a 2D list to eventually be returned as a result of the function
		for j in range(0, len(secondrow)):
			row.append(multiplyforscalar(firstrow[i], secondrow[j]))
		result.append(row)
	return result										#returns the calculation tot the main function

def multiplyforscalar(one, theOther):

	total = 0
	for i in range(0, len((one))):
		product = one[i] * theOther[i]					#completes calculation
		total += product
	return total										#returns calculation to the scalar multiplication function

def outputMatrix(name, matrix, outFileHandle):			#writes the name, an ‘=’ and a matrix to the opened file

	outFileHandle.write(name + "=")						#writes title of matrices and equals symbol
	try:												#try statement for correct matrix parameters
		for i in matrix:
			for j in i:
				outFileHandle.write("\t" + str(j))		#writes lines in matrix
			outFileHandle.write("\n")					#writes line for second dimention in matrix
	except TypeError: 										#creates parameters for a TypeError
		outFileHandle.write("\t" + str(matrix) + "\n")		#writes tab, matrix, then newline for TypeError condition



def main():											#begins main function

	print('MATRIX ARITHMETIC\n')								#prints fuction's title
	print('Inputting Matrices A, B and D and scalar c . . . . . . . . . . Result Written to file: MatrixResult.txt')    #prints fuction's purpose

	matrixfile = open("MatrixIn.txt", "r")				#opens file with matrix parameters to create matrix
	matrixoutputfile = open("MatrixResult.txt", "w")		#creates file to write the outputs of the created matrices
	text = matrixfile.readlines()						#seperates initial input file into lines
	matrixfile.close()									#closes initial input file
	count = 0
	
	while count < len(text):							#creates while loop to limit output to the end of the input text
		makelist = []									#creates list to perform calculations on
		for line in range(count, count + 4):			#creates loop to split in 4 line intervals for seperate matrixes
			makelist.append(MatrixIn(text[line]))		#appends lines of text from MatrixIn to makelist
		A = makelist[0]									#Designates the first element in makelist to the first matrix
		B = makelist[1]									#Designates the second element in makelist to the second matrix		
		C = makelist[2]									#Designates the third element in makelist to the third matrix
		D = makelist[3]									#Designates the fourth element in makelist to the fourth matrix
		AplusB = addMatrix(A, B)						#creates variable from function calculations 
		AminusB = subtractMatrix(A,B)					#creates variable from function calculations 
		CA = scalarMultiply(C, A)						#creates variable from function calculations 
		AdotD = dot(A, D)								#creates variable from function calculations 
		outputMatrix("A", A, matrixoutputfile)				#sends title, and calculation to the outputMatrix function for output
		outputMatrix("B", B, matrixoutputfile)				#sends title, and calculation to the outputMatrix function for output
		outputMatrix("C", C, matrixoutputfile)				#sends title, and calculation to the outputMatrix function for output
		outputMatrix("D", D, matrixoutputfile)				#sends title, and calculation to the outputMatrix function for output
		outputMatrix("A+B", AplusB, matrixoutputfile)			#sends title, and calculation to the outputMatrix function for output
		outputMatrix("A-B", AminusB, matrixoutputfile)			#sends title, and calculation for output
		outputMatrix("cA", CA, matrixoutputfile)				#sends title, and calculation for output
		outputMatrix("A dot D", AdotD, matrixoutputfile)			#sends title, and calculation to the outputMatrix function for output
		count += 4													#adds 4 to the count to skip lines to the next matrix
	matrixoutputfile.close()							#closes output file
	
# Do not change *anything* below this line
if __name__ == "__main__":
	main()
