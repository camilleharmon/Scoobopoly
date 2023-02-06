
public class Jeepers extends Property{

	protected Jeepers(String n, int u) {
		
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
	
	public void collect() {
		
		assets.set(player).bank() = assets.get(player).bank() - 200;
	}
}
