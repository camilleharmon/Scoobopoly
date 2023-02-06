
public class CardSpace extends Property{

	protected boolean isZoinks;
	
	protected CardSpace(String n, int u, boolean z) {
		
		name = n;
		umber = u;
		isZoinks = z;
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
	
	public boolean isZoinks() {
		return isZoinks;
	}

	public void setZoinks(boolean isZoinks) {
		this.isZoinks = isZoinks;
	}
	
	
}
