package algorithms.mazeGenerators;
// TODO: Auto-generated Javadoc

/**
 * The Class Position.
 */
public class Position {
	
	/** The xyz. */
	private String xyz;
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/** The z. */
	private int z;
	
	
	/**
	 * Instantiates a new position.
	 *
	 * @param xyz the xyz
	 * Ctor-Transition from string to - int
	 */
	public Position(String xyz)
	{
		String[] arrayxyz = xyz.split(",");
		this.x =Integer.parseInt(arrayxyz[0]) ;
		this.y =Integer.parseInt(arrayxyz[1]) ;
		this.z =Integer.parseInt(arrayxyz[2]) ;
		this.xyz = xyz;
		//System.out.println(this.x);//Print for testing
		//System.out.println(this.y);//Print for testing
		//System.out.println(this.z);//Print for testing
	}
	
	/**
	 * Instantiates a new position.
	 *
	 * @param p the p
	 */
	public Position(Position p)
	{
		this.x=p.getX();
		this.y=p.getY();
		this.z=p.getZ();
		this.xyz = p.getXyz();
	}
	
	/**
	 * Instantiates a new position.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * Ctor-Transition from int to - string
	 */
	public Position(int x, int y, int z)
	{
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.xyz = x+","+y+","+z;
	//	System.out.println(xyz);//Print for testing
	}
	
	/**
	 * Gets the xyz.
	 *
	 * @return the xyz
	 */
	//Getters && Setters
	public String getXyz() {
		return this.xyz;
	}
	
	/**
	 * Sets the xyz.
	 *
	 * @param xyz the new xyz
	 */
	public void setXyz(String xyz) {
		this.xyz = xyz;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Gets the z.
	 *
	 * @return the z
	 */
	public int getZ() {
		return z;
	}
	
	/**
	 * Sets the z.
	 *
	 * @param z the new z
	 */
	public void setZ(int z) {
		this.z = z;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		String string="";
	    string+=("(" + x +"," + y + "," + z + ")");
	    return string;
	}
	
	/**
	 * Prints the position.
	 */
	public void PrintPosition()// print position (x,y,z)
	{
		System.out.println("(" + x +"," + y + "," + z + ")");
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
    public boolean equals(Object obj){ // we override Object's equals method
        return this.xyz.equals(((Position)obj).getXyz());
    }
}
