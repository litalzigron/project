package algorithms.search;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * The Class AbstractSearcher.
 *
 * @param <T> the generic type
 */
public abstract class AbstractSearcher<T> implements Searcher<T>{
	
	 /** The open list - PriorityQueue. */
 	protected PriorityQueue<State<T>> openList = new PriorityQueue<State<T>>();
	 
 	/** The closed set - HashSet. */
 	protected HashSet<State<T>> closedSet=new HashSet<State<T>>();
	 
 	/** The evaluated nodes. */
 	private int evaluatedNodes=0;//כמה קודקודים בדקתי
	 
 	/* (non-Javadoc)
 	 * @see algorithms.search.Searcher#search(algorithms.search.Searchable)
 	 * search by bfs/atar.
 	 */
 	@Override
	 public abstract Solution<T> search(Searchable<T> s);

	 /* (non-Javadoc)
 	 * @see algorithms.search.Searcher#getNumberOfNodesEvaluated()
 	 * return the evaluatedNodes.
 	 */
 	@Override
	 public int getNumberOfNodesEvaluated() {
	  return evaluatedNodes;
	 }
	 
	 /**
 	 * Pop open list.
 	 * add to open list and count the evaluatedNodes.
 	 * @return the state
 	 */
 	protected State<T> popOpenList() {
		  evaluatedNodes++;
		  return openList.poll();
	 }

	 /**
 	 * Generate path to goal.
 	 * return backtrace the path to goal
 	 * @param goalState the goal state
 	 * @return the solution
 	 */
 	protected Solution <T>generatePathToGoal(State<T> goalState) {
			Solution<T> solution=new Solution<T>();		
			solution.addState(goalState);
			do
			{
				solution.addState(goalState.getCameFrom());
				goalState = goalState.getCameFrom();
			} while (goalState.getCameFrom() != null);
			return solution;
		}	
	

}
