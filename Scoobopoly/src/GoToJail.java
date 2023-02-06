
public class GoToJail extends Property{

	protected GoToJail(String n, int u) {
		
		name = n;
		umber = u;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUmber() {
		return umber;
	}

	public void setUmber(int umber) {
		this.umber = umber;
	}
	
	public void arrest() {
		
		player.set(player).jail() = true;
	}
}
