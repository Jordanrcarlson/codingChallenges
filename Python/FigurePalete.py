# Edit this file for Assignment #3
# Jordan Carlson V00714886
# October 20, 2018

def main(): #Begin main function
    
    print("I N T E G E R  F I G U R E S \n\n")  #Title and introduction to program
    print ('   1: Rectangle')
    print('   2: Square')
    print('   3: Diamond')
    print('   4: Horizontal Line')
    print('   5: Vertical Line')
    print('   6: Triangle (top left)')
    print('   7: Triangle (bottom right)\n' )
    print('Input Line 1: 1-7 specifies shape (0-end)') #Introduce user inputs to specify shape and size
    print('Input Line 2: Symbol (0-9)')
    print('Input Line 3: Shape size (integer)')
    print('Input Line 4 (for rectangle): Shape width (integer) ')
    print()

    userinput = 1      #sets condition for loop to start
    while userinput == 1:   #while loop will execute to allow for multiple shapes until 0 is entered
        symbol = 1
        width = 1
        height = 1
        length = 1
        line = str(input('line 1: '))       #line 1 for user to enter desired shape
        if line == '1':
            symbol = str(input('line 2: '))   #line 2 for user to enter symbol
            height = int(input('line 3: '))   #line 3 for user to enter shape size
            width = int(input('line 4: '))   #line 4 for user to enter shape size
            print()
            rectangle(symbol, height, width)   #calls on the rectangle function
            print()
        elif line == '2':
            symbol = str(input('line 2: ')) #elifs for each possible shape choice
            width = int(input('line 3: '))
            print()
            square(symbol, width)
            print()
        elif line == '3':
            symbol = str(input('line 2: '))
            width = int(input('line 3: '))
            print()
            diamond(symbol, width)
            print()
        elif line == '4': 
            symbol = str(input('line 2: '))
            length = int(input('line 3: '))
            print()
            horizLine(symbol, length)
            print()
        elif line == '5':
            symbol = str(input('line 2: '))
            length = int(input('line 3: '))
            print()
            vertLine(symbol, length)
            print()
        elif line == '6':
            symbol = str(input('line 2: '))
            height = int(input('line 3: '))
            print()
            leftTopTriangle(symbol, height)
            print()
        elif line == '7':
            symbol = str(input('line 2: '))
            height = int(input('line 3: '))
            print()
            rightBottomTriangle(symbol, height)
            print()
        else:
            userinput = print(end = '')  #ends program with inputs other than 

    print()


def rectangle(symbol, height, width):     #Rectangle function
    
    for w in range (width):                       #for loop for width
        for h in range(height):                 #for loop for height
            print(symbol + '.', end = '')          #print symbols within parameters
        print()                               #go to the next line within the outside for loop to print symbols


                                #Square Function
def square(symbol, width): 
    
    for h in range (width):                         #for loop for width
        for w in range (width):                 #for loop for height
            print (str(symbol) + '.', end='')         #print symbols within parameters
        print() 


                                #Diamond Function
def diamond(symbol, width): 
    
    if (width % 2 == 1):                        #for odd inputs
        width += 1                              #adds an extra line of output to compete diamond
        width //= 2                                #divides input by two
        for length in range (1, width):                   #for top half of diamond
            for underscores in range (width - length):        #print underscores in amount depending on area in triangle
                print('_', end = '.')
            for tophalf in range((length * 2) - 1):           #print symbols and other periods as needed to complete diamond
                print(symbol + '.', end = '')
            print()                                       #ends line to begin outputting on next line
        for length in range (width, 0, - 1):
            for underscores in range (width - length):
                print('_', end = '.')
            for bottomhalf in range((length * 2) - 1):
                print(symbol + '.', end='')
            print()                                     #ends line to begin outputting on next line
   #even 
    else:                                #same procedure as top half of diamond but for even inputs
        size = width//2              #divides input by two
        height = 1                      #sets condition to begin for loop
        while size > 0:                  #begins while loop to continue until diamond size is 0
            for columns in range (size):
                print('_' + '.', end = '')      #print underscores in amount depending on area in diamond
            for rows in range (height):
                print(symbol + '.', end = '')        #print symbols and other periods as needed to complete diamond
            size -= 1 
            height += 2
            print()                              #ends line to begin outputting on next line
        size = 1
        height = width - 1
        while size < width / 2 + 1:
            for columns in range (size):        
                print('_' + '.', end = '')     #print underscores in amount depending on area in diamond
            for rows in range (height):
                print(symbol + '.', end = '')     #print symbols and other periods as needed to complete diamond
            size += 1
            height -= 2                        
            print()                      #ends line to begin outputting on next line

                                          #Horizontal Line function
def horizLine(symbol, length): 

    for length in range (length):                        #for loop to continue for row length
        print (symbol + '.', end = '')                       #print symbols within parameters

                                  #Vertical Line function
def vertLine(symbol, length): 
    for length in range (length):              #for loop to continue for height of shape
        print (symbol + '.')                #print symbols within parameters


                                         #Triangle (Top Left) function
def leftTopTriangle(symbol, height): 
    for rows in range (height):                            #for loop to continue for row length
        userinput = symbol
        for size in range ((height - 1) - rows):           #for loop to continue for height of shape
            size = symbol
            userinput = userinput + '.' + size            #print symbols within parameters
        print(userinput + '.')

                                               #Triangle (Bottom Right) function
def rightBottomTriangle(symbol, height): 
    for rows in range (height):                           #for loop to continue for row length
        for columns in range (height - (rows+1)):
            print('_' + '.', end='')                                 #print symbols within parameters
        for size in range (height - ((height - (rows + 1)))):   #for loop to continue for height of shape
            print(symbol + '.', end = '')                                  #print symbols within parameters
        print()                      #ends line to begin outputting on next line


	

# *** Do not edit anything below this line ***
if __name__ == "__main__":
	main()