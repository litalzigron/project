package algorithms.mazeGenerators;

/**
 * The Class AbstractMaze3dGenerator.
 */
public abstract class AbstractMaze3dGenerator implements Maze3dGenerator {

	/** The maze. */
	protected Maze3d maze;
	
	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.Maze3dGenerator#generate(int, int, int)
	 */
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
		return null;
	}
	
	/* (non-Javadoc)
	 * @see algorithms.mazeGenerators.Maze3dGenerator#measureAlgorithmTime(int, int, int)
	 * return the total time of generate(startTime-finishTime); 
	 */
	@Override
	public String measureAlgorithmTime(int width, int height, int dept) {
		long timeStart = System.currentTimeMillis();
		System.out.println("s");
		generate(width,height,dept);
		System.out.println("ss");
		long timefinish= System.currentTimeMillis();
		long time;
		time= timefinish-timeStart;
		return "start Time: "+timeStart+",  "+ "finish Time: "+timefinish+",  "+"total Time: "+time;
	}
}
