package algorithms.demo;

import java.util.ArrayList;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Searchable;
import algorithms.search.State;

/**
 * The Class SearchableMaze3d.
 */
public class SearchableMaze3d implements Searchable<Position> {
	
	/** The maze. */
	//מתבצע אובייקט אדאפטר כי אנו מכילים מחלקה ויורשים מחלקה בכך אנו משתמשים בפונקציונליות
	Maze3d maze;
	
	/**
	 * Instantiates a new searchable maze3d.
	 *
	 * @param maze the maze
	 */
	//copy C'tor
	public SearchableMaze3d(Maze3d maze) {
		super();
		this.maze = maze;
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getStartState()
	 * return the Start State
	 */
	@Override
	public State<Position> getStartState() {
		State<Position> s = new State<Position>(maze.getStart());
		return s;
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getGoalState()
	 * return the Goal State
	 */
	@Override
	public State<Position> getGoalState() {
		State<Position> s = new State<Position>(maze.getGoal());
		return s;
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getAllPossibleStates(algorithms.search.State)
	 * return array of all possible state from s.
	 */
	
	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State<Position> s) {
		ArrayList<State<Position>> array=new ArrayList<State<Position>>();		
		String[] state;
		state=maze.getAllPosibleMoves(s.getP());	
		for(String i: state )
		{
			Position p=new Position(i);
			State<Position> sp=new State<Position>(p);
			sp.setPrice(1);
			array.add(sp);		
		}		
		return array;
	}
	
	
	
}
