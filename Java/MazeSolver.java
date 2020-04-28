//Name: Jordan Carlson
//Student Number: V00714886

/*
 * MazeSolver.java
 *
 * UVic CSC 115, Spring 2017
 *
 * Purpose:
 *   class that contains a single public static method called
 *   "findPath". To involve the method one must have already created
 *   an instance of Maze. The method must return a path through the
 *   maze (if it exists) in the format shown within the Assignment #3
 *   description.
 *
 * Note: You are free to add to this class whatever other methods will
 * help you in writing a solution to A#3 part 2.
 */


public class MazeSolver{      //main class
    public static String findPath(Maze maze) {

		MazeLocation spot = maze.getEntry();    //initializations
    int x = 0;
    int y = 0;
		int rows = maze.getNumRows();
		int columns = maze.getNumCols();
		boolean[][] route = new boolean[rows][columns];

		for(int row = 0 ; row < rows; row++){     //loop through maze determining by boolean if spots are viable routes
			for(int column = 0 ; column < columns; column++){
				if(maze.isWall(row, column)){
					route[row][column] = true;
				}
				else{
					route[row][column] = false;
				}
		}	}

		MazeLocation exit;    //assign exit as an maze object
		exit = maze.getExit();

		int xexit = exit.getRow();
		int yexit = exit.getCol();

		StackRefBased<MazeLocation> current = new StackRefBased<MazeLocation>();
		current.push(spot);         //start stacking at the exit

		MazeLocation top = spot;
		boolean path = false;

		while(!current.isEmpty()){    //catch empty stack exception
			try{
				spot = current.peek();
			}
      catch (StackEmptyException e){
            	System.out.print("");
      }

			x = spot.getRow();
			y = spot.getCol();

			if(x == xexit && y == yexit){
				break;
			}
			route[x][y] = true;

			MazeLocation add;

   if(x == rows - 1){               //goes through maze stacking co-ordinates to entry

      if(!route[x - 1][y]) {
        add = new MazeLocation(x - 1, y);
        current.push(add);
        top = add;
      }
      else if(!route[x][y - 1]) {
        add = new MazeLocation(x, y - 1);
        current.push(add);
        top = add;
      }
      else if(!route[x][y + 1]) {
        add = new MazeLocation(x, y + 1);
        current.push(add);
        top = add;
      }
      else try{
        spot = current.pop();
      }catch (StackEmptyException e) {
              System.out.print("");
      }
    } else if(x == 0){
				if(!route[x + 1][y])
				{
					add = new MazeLocation(x + 1, y);
					current.push(add);
					top = add;
				}
        else if(!route[x][y - 1]) {
          add = new MazeLocation(x, y - 1);
          current.push(add);
          top = add;
        }
				else if(!route[x][y + 1]) {
					add = new MazeLocation(x, y+1);
					current.push(add);
					top = add;
				}

				else try{
					spot = current.pop();
				}catch (StackEmptyException e) {
            		System.out.print("");
        }
			}else{
				if(!route[x + 1][y]) {
					add = new MazeLocation(x + 1, y);
					current.push(add);
					top = add;
				}
        else if(!route[x - 1][y]) {
          add = new MazeLocation(x - 1, y);
          current.push(add);
          top = add;
        }
        else if(!route[x][y - 1]) {
          add = new MazeLocation(x, y - 1);
          current.push(add);
          top = add;
        }
				else if(!route[x][y + 1]) {
					add = new MazeLocation(x, y + 1);
					current.push(add);
					top = add;
				}
				else try{
					spot = current.pop();
				}catch (StackEmptyException e) {
            		System.out.print("");
        }
			}
			if(current.isEmpty()){
				path = false;
			}
			else{
				path = true;
			}
		}
    String output = "";           //creates output of co-ordinates of maze locations for testing
		if(path){
			while(!current.isEmpty()){
				MazeLocation end;
				try{
					end = current.pop();
					if(output == "") {
						output = end.toString();
					}
					else{
						output = end.toString() + " " + output;
					}
				}catch (StackEmptyException e){
					System.out.print("");
				}
			}
		}
    return output;
    }
}
