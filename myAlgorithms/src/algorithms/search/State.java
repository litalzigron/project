package algorithms.search;

// TODO: Auto-generated Javadoc
/**
 * The Class State.
 *
 * @param <T> the generic type
 */
public class State <T> implements Comparable<State<T>>{
	
	/** The came from. */
	private State<T> cameFrom;//מאיזה נקודה הגעתי the state we came from to this state
	
	/** The price. */
	private double price ;// מחיר price to reach this state
	
	/** The p. */
	private T p;//position ייצוג המצב בנקודות
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){//פונקציית ה p היא פונקציה שמחזירה לכל אובייקט מספר ייחודי. 
		return p.toString().hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
    public boolean equals(Object obj){ // we override Object's equals method
        return this.p.equals(((State<T>)obj).getP());
    } 
	
	/**
	 * Instantiates a new state.
	 *
	 * @param cameFrom the came from
	 * @param price the price
	 * @param p the p
	 */
	public State( State<T> cameFrom, double price, T p) {
		super();
		this.cameFrom = cameFrom;
		this.price = price;
		this.p = p;
	}
	
	/**
	 * Instantiates a new state.
	 *
	 * @param p the p
	 */
	public State (T p) {
		super();
		this.p = p;
		this.price=0;
		this.cameFrom = null;
	}
	
	/**
	 * Gets the came from.
	 *
	 * @return the came from
	 */
	public State<T> getCameFrom() {
		return this.cameFrom;
	}
	
	/**
	 * Sets the came from.
	 *
	 * @param cameFrom the new came from
	 */
	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Gets the p.
	 *
	 * @return the p
	 */
	public T getP() {
		return this.p;
	}
	
	/**
	 * Sets the p.
	 *
	 * @param p the new p
	 */
	public void setP(T p) {
		this.p = p;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()	{
		return p.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override//לתקןןןןןןןןןןןןןן
	public int compareTo(State<T> o) {
		// TODO Auto-generated method stub
		return (int)(this.price - o.getPrice()); 
	}
}
