
public class GoToJail extends Property{

	protected GoToJail(String n, int u) {
		
		name = n;
		umber = u;
	}
	
	public void arrest() {
		
		player.set(player).jail() = true;
	}
}
