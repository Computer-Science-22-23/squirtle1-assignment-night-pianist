
public class FlowerThing extends PokeThing
{

	/**
	 * Creates a new <code>FlowerThing</code> object.
	 * Associated graphics file will be flower.gif
	 * A FlowerThing is not a PokeThing and does not count as a Pokemon
	 */
	public FlowerThing()
	{
		super("flower", "", 1);
	}
	
	public void step()
	{
		Board b = getBoard();
		Location l = getLocation();
		
		if(b.thingAt(l) instanceof SquirtleThing)
		{
			b.remove(this);
		}
	}

}
