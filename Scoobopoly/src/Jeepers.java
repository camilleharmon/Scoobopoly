
public class Jeepers extends Property{

	protected Jeepers(String n, int u) {
		
		name = n;
		umber = u;
	}
	
	public void collect() {
		
		assets.set(player).bank() = assets.get(player).bank() - 200;
	}
}
