package algorithms.mazeGenerators;

/**
 * The Class DfsMaze3dGenerator.
 */
public class DfsMaze3dGenerator extends AbstractMaze3dGenerator {
	
	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.AbstractMaze3dGenerator#generate(int, int, int)
	 * generate the maze
	 */
	@Override
	public Maze3d generate(int width, int height, int dept) {
		maze =new Maze3d(width,height,dept);  //Creating a maze
		maze.InitMaze3d(); //Initialization the Maze3d to 1
		/* Random start */
		Position sp= maze.randomPosition();
		maze.setStart(sp);
		maze.setValue(sp.getX(), sp.getY(), sp.getZ(), 0);
		CreatedfsMaze3d(sp.getX(), sp.getY(), sp.getZ());
		System.out.println("---end generate Dfs---");
		System.out.println("The start: "+maze.getStart());
		System.out.println("The Goal: "+maze.getGoal());
		if(maze.getGoal()!=null)
		return maze;
		else
			return null;
	}
	
	/**
	 * Equal strat end.
	 *
	 * @param sp the sp
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @return true, if successful
	 * //If two identical Position be returned true another false
	 */
	public boolean equalStratEnd(Position sp,int x,int y, int z)
	{
		return (sp.getX()==x && sp.getY()==y && sp.getZ()==z) ? true : false;
	}
	
	/**
	 * Createdfs maze3d.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public void CreatedfsMaze3d(int x, int y, int z){
	
			if((maze.isValid(x,y+1,z)==true&&maze.onlyOne(x,y+1,z)==true&&(equalStratEnd(maze.getStart(),x,y+1,z)==false)&&(maze.getValue(x, y+1, z)!=0)==true))
			{
				maze.setValue(x,y+1,z,0);
				Position pg =new Position(x,y+1,z);
				maze.setGoal(pg);
				CreatedfsMaze3d(x,y+1,z);
			}
			if((maze.isValid(x,y-1,z)==true&&maze.onlyOne(x,y-1,z)==true&&(equalStratEnd(maze.getStart(),x,y-1,z)==false)&&(maze.getValue(x, y-1, z)!=0)==true))
			{
				maze.setValue(x,y-1,z,0);
				Position pg =new Position(x,y-1,z);
				maze.setGoal(pg);

				CreatedfsMaze3d(x,y-1,z);
			} 
			if((maze.isValid(x+1,y,z)==true&&maze.onlyOne(x+1,y,z)==true&&(equalStratEnd(maze.getStart(),x+1,y,z)==false)&&(maze.getValue(x+1, y, z)!=0)==true))
			{
				maze.setValue(x+1,y,z,0);
				Position pg =new Position(x+1,y,z);
				maze.setGoal(pg);
				CreatedfsMaze3d(x+1,y,z);
			}
			if((maze.isValid(x-1,y,z)==true&&maze.onlyOne(x-1,y,z)==true&&(equalStratEnd(maze.getStart(),x-1,y,z)==false)&&(maze.getValue(x-1, y, z)!=0)==true))
			{
				maze.setValue(x-1,y,z,0);
				Position pg =new Position(x-1,y,z);
				maze.setGoal(pg);
				CreatedfsMaze3d(x-1,y,z);
			}
			if((maze.isValid(x,y,z+1)==true&&maze.onlyOne(x,y,z+1)==true&&(equalStratEnd(maze.getStart(),x,y,z+1)==false)&&(maze.getValue(x, y, z+1)!=0)==true))
			{
				maze.setValue(x,y,z+1,0);
				Position pg =new Position(x,y,z+1);
				maze.setGoal(pg);
				CreatedfsMaze3d(x,y,z+1);
			} 
			if((maze.isValid(x,y,z-1)==true&&maze.onlyOne(x,y,z-1)==true&&(equalStratEnd(maze.getStart(),x,y,z-1)==false)&&(maze.getValue(x, y, z-1)!=0)==true))
			{
				maze.setValue(x,y,z-1,0);
				Position pg =new Position(x,y,z-1);
				maze.setGoal(pg);
				CreatedfsMaze3d(x,y,z-1);
			}	
	
		}
	}


		
		
		
		
		
		
		
		