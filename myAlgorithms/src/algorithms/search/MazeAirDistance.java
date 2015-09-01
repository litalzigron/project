package algorithms.search;

import algorithms.mazeGenerators.Position;

/**
 * The Class MazeAirDistance.
 */
public class MazeAirDistance implements Heuristic <Position>
{	
	
	/* (non-Javadoc)
	 * @see algorithms.search.Heuristic#h(algorithms.search.State, algorithms.search.State)
	 */
	public double h(State<Position> current,State<Position> neighbor)
	{
		double distanceX=0;
		double distanceY=0;
		double distanceZ=0;
	    distanceX= Math.abs(current.getP().getX()-neighbor.getP().getX());
	    distanceY= Math.abs(current.getP().getY()-neighbor.getP().getY());
		distanceZ= Math.abs(current.getP().getZ()-neighbor.getP().getZ());
		return distanceX+distanceY+distanceZ;
	}
}
