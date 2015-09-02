package algorithms.mazeGenerators;

import java.util.ArrayList;

/**
 * The Class Maze3d.
 */
public class Maze3d {
	
	/** The maze. */
	//Data Members
	private int [][][] maze;
	
	/** The depth. */
	private int width,height,depth;//x,y,z
	
	/** The goal. */
	private Position start, goal;
	
	/**
	 * Instantiates a new maze3d.
	 *
	 * @param width the width
	 * @param height the height
	 * @param depth the depth
	 */
	public Maze3d(int width, int height, int depth)//Ctor
	{
		super();
		this.width=width;
		this.height=height;
		this.depth=depth;
		this.maze = new int [width][height][depth];
	}
	
	public Maze3d(byte[] maze3dArrayToBytes)//Ctor
	{
		super();
		this.start= new Position((int)maze3dArrayToBytes[0], (int)maze3dArrayToBytes[1], (int)maze3dArrayToBytes[2]);		
		this.goal=new Position((int)maze3dArrayToBytes[3], (int)maze3dArrayToBytes[4], (int)maze3dArrayToBytes[5]);
		
		this.width=(int)maze3dArrayToBytes[6];
		this.height=(int)maze3dArrayToBytes[7];
		this.depth=(int)maze3dArrayToBytes[8];
		
		this.maze = new int [width][height][depth];
		int k=9;
		for(int i=0; i<depth; i++)
		{
			for(int j=0;j<height; j++)
			{
				for(int t=0;t<width; t++)
				{
					maze[t][j][i]=(int)maze3dArrayToBytes[k];
					k++;
				}
			}
		}
	}
	
	/**
	 * Gets the maze.
	 *
	 * @return the maze
	 */
	//Getters && Setters
	public int[][][] getMaze() {
		return maze;
	}
	
	/**
	 * Gets the depth.
	 *
	 * @return the depth
	 */
	public int getdepth() {
		return depth;
	}
	
	/**
	 * Sets the depth.
	 *
	 * @param depth the new depth
	 */
	public void setdepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * Sets the maze.
	 *
	 * @param maze the new maze
	 */
	public void setMaze(int[][][] maze) {
		this.maze = maze;
	}
	
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Gets the start.
	 *
	 * @return the start
	 */
	public Position getStart() {
		return start;
	}
	
	/**
	 * Sets the start.
	 *
	 * @param start the new start
	 */
	public void setStart(Position start) {
		this.start = start;
	}
	
	/**
	 * Gets the goal.
	 *
	 * @return the goal
	 */
	public Position getGoal() {
		return goal;
	}
	
	/**
	 * Sets the goal.
	 *
	 * @param goal the new goal
	 */
	public void setGoal(Position goal) {
		this.goal = goal;
	}

/**
 * Gets the value.
 *
 * @param x the x
 * @param y the y
 * @param z the z
 * @return the value
 */
	public int getValue(int x, int y, int z)
	{
		return maze[x][y][z];
	}
	
	/**
	 * Sets the value.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @param num the num
	 */
	public void setValue(int x, int y, int z, int num)// set value in the maze3d[x][y][z]
	{
		if(num!=0&&num!=1)
		{
			System.out.println("Invalid Input");
		}
		else
		maze[x][y][z]=num;
	}

	@Override
	public String toString()
	{
		String string="";
		string+="Start="+this.start+"\n"+"Goal="+this.goal+"\n";
		for(int i=0; i<width; i++)
		{
			for(int j=0;j<height; j++)
			{
				for(int t=0;t<depth; t++)
				{
					string+="["+maze[i][j][t]+"]";
				}
			}
		}
		return string;
	}
	
	/**
	 * Gets the all posible moves.
	 *
	 * @param current the current
	 * @return the all possible moves
	 *  Returns the positions in which the value is not 1
	 */
	public String[] getAllPosibleMoves(Position current)
	{ 
		ArrayList<String> movespossible=new ArrayList<String>();
		int x = current.getX();
		int y = current.getY();
		int z = current.getZ();
		if(isValid(x,y,z)==false)
			return null;
		if(isValid(x, y, z+1)==true && maze[x][y][z+1]==0)
		{
			movespossible.add(x+","+y+","+(z+1));
		}
		if(isValid(x, y, z-1)==true &&maze[x][y][z-1]==0)
		{
			movespossible.add(x+","+y+","+(z-1));
		}
		if(isValid(x, y+1, z)==true &&maze[x][y+1][z]==0)
		{
			movespossible.add(x+","+(y+1)+","+z);
		}
		if(isValid(x, y-1, z)==true &&maze[x][y-1][z]==0)
		{
			movespossible.add(x+","+(y-1)+","+z);
		}
		if(isValid(x+1, y, z)==true && maze[x+1][y][z]==0)
		{
			movespossible.add((x+1)+","+y+","+z);
		}
		if(isValid(x-1, y, z)==true && maze[x-1][y][z]==0)
		{
			movespossible.add((x-1)+","+y+","+z);
		}
		String [] moves = new String [movespossible.size()];
		for (int i = 0; i < moves.length; i++) {
			moves[i] = movespossible.get(i);
		}
		return moves;
	}
	
	/**
	 * Gets the cross section by x.
	 *
	 * @param x the x
	 * @return the cross section by x
	 */
	public int [][] getCrossSectionByX(int x)
	{
		if (x < 0) { 
			throw new IndexOutOfBoundsException("Invalid Input: getCrossSectionByX");
		}	
		int [][]arrayX=new int [height][depth];
		System.out.println("getCrossSectionByX");
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<depth;j++)
				arrayX[i][j]=maze[x][i][j];
		}
		return arrayX;
	}
	
	/**
	 * Gets the cross section by y.
	 *
	 * @param y the y
	 * @return the cross section by y
	 */
	public int [][] getCrossSectionByY(int y)
	{
		if (y < 0) { 
			throw new IndexOutOfBoundsException("Invalid Input: getCrossSectionByY");
		}	
		int [][]arrayY=new int [depth][width];
		System.out.println("getCrossSectionByY");
		for(int i=0;i<depth;i++)
		{
			for(int j=0;j<width;j++)
				arrayY[i][j]=maze[j][y][i];
		}
		return arrayY;
	}
	
	/**
	 * Gets the cross section by z.
	 *
	 * @param z the z
	 * @return the cross section by z
	 */
	public int [][] getCrossSectionByZ(int z)
	{
		if (z < 0) { 
			throw new IndexOutOfBoundsException("Invalid Input: getCrossSectionByZ");
		}	
		int [][]arrayZ=new int [height][width];
		System.out.println("getCrossSectionByZ");
		for(int i=0;i<height;i++)
		{
			for(int j=0;j< width;j++)
			{
				arrayZ[i][j]= maze[j][i][z];
			}
		}
		return arrayZ;
	}	
	
	/**
	 * Initialize the maze3d.
	 */
	public void InitMaze3d()//Initialization the Maze3d to 1
	{
		System.out.println("width: "+width);
		System.out.println("hight: "+height);
		System.out.println("depth: "+depth);

		for(int i=0; i<depth; i++)
		{
			for(int j=0;j<height; j++)
			{
				for(int t=0;t<width; t++)
				{
					maze[t][j][i]=1;
				}
			}
		}
	}
	
	/**
	 * Random compare.
	 *
	 * @param StartPosition the StartPosition
	 * @return the position
	 */
	public Position RandomCompare(Position startPosition)//random position
	{
		int px,py,pz;
		do{
			px = (int) (Math.random()*(width));
		}while(startPosition.getX()>px);
		do{
			 py = (int) (Math.random()*(height));
		}while(startPosition.getY()>py);
		do{
			 pz = (int) (Math.random()*(depth));
		}while(startPosition.getZ()>pz);
		Position p=new Position(px,py,pz);
		return p;
	}
	
	/**
	 * Random.
	 *
	 * @return the position
	 */
	public Position randomPosition()//random position
	{
		int px = (int) (Math.random()*(width));
		int py = (int) (Math.random()*(height));
		int pz = (int) (Math.random()*(depth));
		Position p=new Position(px,py,pz);
		return p;
	}
	
	/**
	 * Prints the maze.
	 */
	public void printMaze()
	{
		for(int i=0; i<depth; i++)
		{
			for(int j=0;j<height; j++)
			{
				for(int t=0;t<width; t++)
				{
					System.out.print(maze[t][j][i]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @return true, if is valid
	 * checking -if is not out of bounds 
	 */
	public boolean isValid(int x, int y, int z)
	{	
		if (x>=0 &&y>=0 && z>=0 &&  x<width && y<height && z<depth ){
			return true;
		}
		return false;
	}
	
	/**
	 * Only one.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @return the boolean
	 */
	//checking -There are only one zero around 
	public Boolean onlyOne(int x, int y, int z)
	{
		int count =0 ;
		if (x+1<width)
		{
			if(maze[x+1][y][z]==0)
			count++;
		}	
		if (x-1>=0)
		{
			if(maze[x-1][y][z]==0)
			count++;
		}
		if (y+1<height)
		{
			if(maze[x][y+1][z]==0)
			count++;
		}
		if (y-1>=0)
		{
			if(maze[x][y-1][z]==0)
			count++;
		}
		if (z+1<depth)
		{
			if(maze[x][y][z+1]==0)
			count++;
		}
		if (z-1>=0)
		{
			if(maze[x][y][z-1]==0)
			count++;
		}
		if(count==1)
			return true;
		else
			return false;
	}
	public byte[] toByteArray() {
		int size = 8 + (this.width*this.height*this.depth);
		byte[] maze3dArrayToBytes = new byte[size+1];
		maze3dArrayToBytes[0]=(byte)this.start.getX();
		maze3dArrayToBytes[1]=(byte)this.start.getY();
		maze3dArrayToBytes[2]=(byte)this.start.getZ();
		
		maze3dArrayToBytes[3]=(byte)this.goal.getX();
		maze3dArrayToBytes[4]=(byte)this.goal.getY();
		maze3dArrayToBytes[5]=(byte)this.goal.getZ();
		
		maze3dArrayToBytes[6]=(byte) this.width;
		maze3dArrayToBytes[7]=(byte) this.height;
		maze3dArrayToBytes[8]=(byte) this.depth;
		
		int k=9;
		for(int i=0;i<depth;i++)
		{
			for(int j=0;j<height; j++)
			{
				for(int t=0;t<width; t++)
				{
					maze3dArrayToBytes[k]=(byte)(this.maze[t][j][i]);
					k++;
				}
			}
		}
		System.out.print("tobyte: ");
		for(int i=0;i<k;i++)
			System.out.print(maze3dArrayToBytes[i]+",");
		System.out.println();
		return maze3dArrayToBytes;
		
	}
	/*
	@Override
    public boolean equals(Object obj){ // we override Object's equals method
        //return this.xyz.equals(((Position)obj).getXyz());
		return this.
    }*/
}
