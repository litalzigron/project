package algorithms.search;

// TODO: Auto-generated Javadoc
/**
 * The Interface Heuristic.
 *
 * @param <T> the generic type
 */
public interface Heuristic<T> {
	
	/**
	 * H.
	 *
	 * @param current the current
	 * @param neighbor the neighbor
	 * @return the double
	 */
	public double h(State<T> current,State<T> neighbor);

}
