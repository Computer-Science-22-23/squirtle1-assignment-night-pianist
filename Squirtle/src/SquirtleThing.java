
public class SquirtleThing extends PokeThing {

	int squaresMoved = 0;

	
	/**
	 * SquirtleThing Constructor
	 * Creates a new <code>SquirtleThing</code> object.
	 * Associated graphics file will be squirtle.png
	 */
	public SquirtleThing()
	{
		super("Squirtle", "", 0);	
		setImageFileType(IMAGETYPE_PNG);
	}
	
	
	
	/**
	 * movement in a repeating pattern
	 * <code>SquirtleThing</code> turns right if it encounters a wall
	 */	
	public void movementPattern()
	{		
		Location nextLoc = getDirection().getNextLocation(getLocation()); 
		
		if(getBoard().thingAt(nextLoc) instanceof FlowerThing)
        {
            FlowerThing f = (FlowerThing) getBoard().thingAt(nextLoc);
            getBoard().remove(f);
            
            Gui g = getBoard().getGui();
            g.appendTextWindow("Squirtle captured a flower!");
    		
        }
		
		// Check the 'next' Location.  If there is a PokeThing or wall there, turn.
		boolean stuck = !(nextLoc.isValid(getBoard()));
		

	    if(stuck) 
		{
			setDirection(getDirection().right());
		}
		
		move();
	}
	
	/**
	 * step method -- this method is called over and over
	 * <code>SquirtleThing</code> moves in a pattern and prints how far it has gone
	 */	
	
	public void step()
	{
		Gui g = getBoard().getGui();
		
		//moves the Squirtle
		movementPattern();

		
		/*Location L = getLocation();
		if(getBoard().thingAt(L) instanceof FlowerThing)
		{
			//System.out.println("Test");
			FlowerThing k = (FlowerThing) getBoard().thingAt(L);
			getBoard().remove(k);
		}
		*/
	
		
		squaresMoved += 1; 
		//prints the number of squares moved
		g.appendTextWindow("Squirtle has moved " + squaresMoved + " squares");
		//}
	}
	
	public void move(Location loc)
	{
		// If this PokeThing isn't in a board, or the location is valid, don't move
		if ((null == getBoard()) || (false == loc.isValid(getBoard())))
		{
			return;
		}

		// Remove self from the current location on the Board and add to loc
		getBoard().remove(this);
		setLocation(loc);
		getBoard().add(this);
	}
}
