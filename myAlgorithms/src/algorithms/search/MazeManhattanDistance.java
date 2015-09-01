package algorithms.search;

import algorithms.mazeGenerators.Position;

/**
 * The Class MazeManhattanDistance.
 */
public class MazeManhattanDistance implements Heuristic  <Position>{

	/* (non-Javadoc)
	 * @see algorithms.search.Heuristic#h(algorithms.search.State, algorithms.search.State)
	 */
	public double h(State<Position> current,State<Position> neighbor)
	{
		double distanceX=0;
		double distanceY=0;
		double distanceZ=0;
	    distanceX= Math.pow(current.getP().getX()-neighbor.getP().getX(),2);
	    distanceY= Math.pow(current.getP().getY()-neighbor.getP().getY(),2);
		distanceZ= Math.pow(current.getP().getZ()-neighbor.getP().getZ(),2);
		return Math.sqrt(distanceX+distanceY+distanceZ);
	}
}
