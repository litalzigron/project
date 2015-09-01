package algorithms.search;

import java.util.ArrayList;

/**
 * The Class Solution.
 *
 * @param <T> the generic type
 */
public class Solution<T> {
	
	/** The solution. */
	private  ArrayList<State<T>> solution = new ArrayList<State<T>>();
	
	/**
	 * Gets the solution.
	 *
	 * @return the solution
	 */
	public ArrayList<State<T>> getSolution() {
		
		return solution;
	}
	
	/**
	 * Sets the solution.
	 *
	 * @param solution the new solution
	 */
	public void setSolution(ArrayList<State<T>> solution) {
		this.solution = solution;
	}
	
	/**
	 * Adds the state.
	 *
	 * @param state the array state
	 */
	//יכניס נקודה למערך
	public void addState(State<T> state) {
			this.solution.add(state);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		for(State<T> s: solution )
			sb.append(s+"<-");
		return sb.toString();
	}
}
