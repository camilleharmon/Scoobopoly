
public class Go extends Property{

	protected Go(String n, int u) {
		
		name = n;
		umber = u;
	}
	
	public void collect() {
		
		assets.set(player).bank() = assets.get(player).bank() + 200;
	}
}
