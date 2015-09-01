package algorithms.mazeGenerators;

// TODO: Auto-generated Javadoc
/**
 * The Interface Maze3dGenerator.
 */
public interface Maze3dGenerator {
	
	/**
	 * Generate.
	 *
	 * @param width the width
	 * @param height the height
	 * @param dept the dept
	 * @return the maze3d
	 */
	public Maze3d generate(int width, int height, int dept);
	
	/**
	 * Measure algorithm time.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @return the string
	 */
	public String measureAlgorithmTime(int x, int y, int z);

}
