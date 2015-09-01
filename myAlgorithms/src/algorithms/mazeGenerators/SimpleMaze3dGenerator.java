package algorithms.mazeGenerators;

/**
 * The Class SimpleMaze3dGenerator.
 */
public class SimpleMaze3dGenerator extends AbstractMaze3dGenerator {
	
	/**
	 * Generate a new Maze3d using a simple maze generator algorithm.
	 *
	 * @param width the width
	 * @param height the height
	 * @param depth the depth
	 * @return the maze3d
	 */
	@Override
	public Maze3d generate(int width, int height, int dept) {
		maze = new Maze3d(width,height,dept);//Creating a maze
		maze.InitMaze3d(); //Initialization the Maze3d to 1
		
		/* Random start */
		Position startPosition;
		do
		{
			startPosition= maze.randomPosition();
		}while(maze.isValid(startPosition.getX(), startPosition.getY(), startPosition.getZ())==false);
		maze.setStart(startPosition);
		maze.setValue(startPosition.getX(), startPosition.getY(), startPosition.getZ(), 0);
		
		/* Random Finish */
		Position endPosition;
		do { 
			endPosition= maze.RandomCompare(startPosition);
		}while(equalStratEnd(startPosition,endPosition)==true);
		maze.setGoal(endPosition);
		maze.setValue(endPosition.getX(), endPosition.getY(), endPosition.getZ(), 0);
		
		Position temp = new Position(startPosition.getX(),startPosition.getY(),startPosition.getZ());		
		int steps=0;
		do{
			steps = (int) (Math.random()*(3));//random 0-"up", 1-"right", 2-"forward"
			switch(steps)
			{
				case 0:	if(temp.getX()!=endPosition.getX()) 
				{
					temp.setX(temp.getX()+1);
					maze.setValue(temp.getX(), temp.getY(), temp.getZ(), 0);
				}
				case 1:	if(temp.getY()!=endPosition.getY()) 
				{
					temp.setY(temp.getY()+1);
					maze.setValue(temp.getX(), temp.getY(), temp.getZ(), 0);
				}
				case 2:	if(temp.getZ()!=endPosition.getZ()) 
				{
					temp.setZ(temp.getZ()+1);
					maze.setValue(temp.getX(), temp.getY(), temp.getZ(), 0);
				}		
			}
		}while(!equalStratEnd(temp,endPosition));// while we have not reached the goal
		System.out.println("---end generate simple---");
		return maze;// return the Maze
	}	
	
	/**
	 * Checking if the start position and end position are equal.
	 *
	 * @param endPosition the start position
	 * @param endPosition the end position
	 * @return true, if successful
	 * If two identical Position be returned true another false
	 */
	public boolean equalStratEnd(Position startPosition,Position endPosition)
	{
		return (startPosition.getX()==endPosition.getX() && startPosition.getY()==endPosition.getY() && startPosition.getZ()==endPosition.getZ()) ? true : false;
	}

}