package algorithms.search;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * The Class Astar.
 *
 * @param <T> the generic type
 */
public class Astar<T> extends AbstractSearcher<T> {
	
	/** The heuristic. */
	protected Heuristic<T> heuristic;
	
	/**
	 * Instantiates a new astar.
	 *
	 * @param heuristic the heuristic
	 */
	public Astar(Heuristic<T> heuristic) {
		super();
		this.heuristic = heuristic;
	}
	
	/* (non-Javadoc)
	 * @see algorithms.search.AbstractSearcher#search(algorithms.search.Searchable)
	 */
	@Override
	 public Solution<T> search(Searchable<T> searchable)
    {
		HashMap<State<T>,Double> StatePrice= new HashMap<State<T>,Double>();
		 State<T> startState=searchable.getStartState();
		 State<T> goalState=searchable.getGoalState();
		openList.add(startState);//נאתחל את תור העדיפויות הנק ההתחלה
		StatePrice.put(startState, startState.getPrice());
		System.out.println("start:"+startState);
		System.out.println("goal:"+goalState);
		while(!openList.isEmpty())
		{
		//	System.out.println(nextStates);
			State<T> state = popOpenList();//נוציא מהתור עדיפויות
			closedSet.add(state);
			if(state.equals(goalState))
			{
				System.out.println("good good!!!");
				return generatePathToGoal(state);
			}
		 ArrayList<State<T>> successors= new  ArrayList<State<T>>();
		 successors = searchable.getAllPossibleStates(state); //however it is implemented
		 for(State<T> s:successors)
		 {
			
			double newPathPrice = state.getPrice() + s.getPrice()+heuristic.h(s, goalState);
			if(!closedSet.contains(s) && !openList.contains(s))
			{
				s.setCameFrom(state);
				s.setPrice(newPathPrice);
				openList.add(s);
				StatePrice.put(s, s.getPrice());
			}
			else
			{
				double oldPathPrice=StatePrice.get(s);
				if(newPathPrice < oldPathPrice)
				{
					s.setCameFrom(state);
					s.setPrice(newPathPrice);
					if (!openList.contains(s))
					{
						openList.add(s);
						StatePrice.put(s, s.getPrice());
					}
					else
					{
						openList.remove(s);
						openList.add(s);
						StatePrice.put(s, s.getPrice());
					}
				}
			}
		 }
	}
	return null;
   }
}




