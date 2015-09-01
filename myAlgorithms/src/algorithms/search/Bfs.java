package algorithms.search;
import java.util.ArrayList;
import java.util.HashMap;
// TODO: Auto-generated Javadoc

/**
 * The Class Bfs.
 *
 * @param <T> the generic type
 * Best-first search is a search algorithm which explores a graph by expanding the most promising node chosen according to a specified rule.
 */
public class Bfs<T> extends AbstractSearcher <T>{
	
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
			
			double newPathPrice = state.getPrice() + s.getPrice();
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
		/* for(State<T> s:successors)
		 {
			 System.out.println("successor: "+s.getP());
			 System.out.println("camefrom: "+s.getCameFrom());
			 System.out.println("price: "+s.getPrice());
		 }*/
	}
	return null;
    }
}


